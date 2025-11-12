package com.miguel.vannucci.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.miguel.vannucci.models.Barco;
import com.miguel.vannucci.models.interfaces.barcoDAO;
import com.miguel.vannucci.database.FabricaConexoes;

public class DAOsBarcoImpl implements barcoDAO {

    private static final Connection connection = FabricaConexoes.getInstance().getConnection();

    @Override
    public int addBarco(int idBarco, String nomeBarco, String tipoBarco, String materialBarco) {
        String query = "INSERT INTO TCA_Barcos_barco (idBarco, nome_barco, tipo_barco, material_barco) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idBarco);
            stmt.setString(2, nomeBarco);
            stmt.setString(3, tipoBarco);
            stmt.setString(4, materialBarco);
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean updateBarco(int idBarco, String nomeBarco, String tipoBarco, String materialBarco) {
        String query = "UPDATE TCA_Barcos_barco SET nome_barco = ?, tipo_barco = ?, material_barco = ? WHERE idBarco = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nomeBarco);
            stmt.setString(2, tipoBarco);
            stmt.setString(3, materialBarco);
            stmt.setInt(4, idBarco);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBarco(int idBarco) {
        String query = "DELETE FROM TCA_Barcos_barco WHERE idBarco = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idBarco);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Barco> getBarcos() {
        String query = "SELECT * FROM TCA_Barcos_barco";
        List<Barco> barcos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Usa o novo construtor (sem cor/tamanho/idUser)
                Barco barco = new Barco(
                        rs.getInt("idBarco"),
                        rs.getString("nome_barco"),
                        rs.getString("tipo_barco"),
                        rs.getString("material_barco")
                );
                barcos.add(barco);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return barcos;
    }

    @Override
    public List<Barco> getBarcosById(int idBarco) {
        String query = "SELECT * FROM TCA_Barcos_barco WHERE idBarco = ?";
        List<Barco> barcos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idBarco);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Barco barco = new Barco(
                            rs.getInt("idBarco"),
                            rs.getString("nome_barco"),
                            rs.getString("tipo_barco"),
                            rs.getString("material_barco")
                    );
                    barcos.add(barco);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return barcos;
    }

    @Override
    public List<Barco> getBarcosByUserId(int idUser) {
        // ✅ Agora os barcos são moldes globais (não pertencem a um usuário específico)
        return getBarcos();
    }
}
