package com.miguel.vannucci.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.miguel.vannucci.models.Carpinteiro;
import com.miguel.vannucci.models.interfaces.CarpinteiroDAO;

public class DAOsCarpinteiroImpl implements CarpinteiroDAO {

    private static final Connection connection = com.miguel.vannucci.database.FabricaConexoes.getInstance().getConnection();

    @Override
    public int addCarpinteiro(Carpinteiro carpinteiro) {
        String query = "INSERT INTO TCA_Barcos_Carpinteiro (idCarpinteiro) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, carpinteiro.getId());
            stmt.execute();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean updateCarpinteiro(Carpinteiro carpinteiro) {
        String query = "UPDATE TCA_Barcos_Carpinteiro SET idCarpinteiro = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, carpinteiro.getId());
            stmt.setInt(2, carpinteiro.getId());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCarpinteiro(int carpinteiroId) {
        String query = "DELETE FROM TCA_Barcos_Carpinteiro WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, carpinteiroId);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Carpinteiro getCarpinteiroById(int carpinteiroId) {
        String query = "SELECT * FROM TCA_Barcos_Carpinteiro WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, carpinteiroId);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                Carpinteiro carpinteiro = new Carpinteiro();
                carpinteiro.setId(rs.getInt("idCarpinteiro"));
                // Preencha outros campos conforme necessário
                return carpinteiro;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Carpinteiro> getCarpinteiros() {
        String query = "SELECT * FROM TCA_Barcos_Carpinteiro";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            var rs = stmt.executeQuery();
            List<Carpinteiro> carpinteiros = new java.util.ArrayList<>();
            while (rs.next()) {
                Carpinteiro carpinteiro = new Carpinteiro();
                carpinteiro.setId(rs.getInt("idCarpinteiro"));
                // Preencha outros campos conforme necessário
                carpinteiros.add(carpinteiro);
            }
            return carpinteiros;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
