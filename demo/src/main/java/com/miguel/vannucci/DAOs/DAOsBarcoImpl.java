package com.miguel.vannucci.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.miguel.vannucci.models.Barco;
import com.miguel.vannucci.models.interfaces.barcoDAO;
public class DAOsBarcoImpl implements barcoDAO{
    
    private static final Connection connection = com.miguel.vannucci.database.FabricaConexoes.getInstance().getConnection();
    @Override
    public int addBarco(int id, String nome, String tipo, String cor, double tamanho, String material) {
        String query = "INSERT INTO TCA_Barcos (id, nome, tipo, cor, tamanho, material) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, nome);   
            stmt.setString(3, tipo);
            stmt.setString(4, cor);
            stmt.setDouble(5, tamanho);
            stmt.setString(6, material);
            stmt.execute();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean updateBarco(int id, String nome, String tipo, String cor, double tamanho, String material) {
        String query = "UPDATE TCA_Barcos SET nome = ?, tipo = ?, cor = ?, tamanho = ?, material = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setString(2, tipo);
            stmt.setString(3, cor);
            stmt.setDouble(4, tamanho);
            stmt.setString(5, material);
            stmt.setInt(6, id);
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBarco(int idBarco) {
        String query = "DELETE FROM TCA_Barcos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idBarco);
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public java.util.List<Barco> getBarcos() {
        String query = "SELECT * FROM TCA_Barcos";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            java.util.List<Barco> barcos = new java.util.ArrayList<>();
            while (rs.next()) {
                Barco barco = new Barco(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("tipo"),
                        rs.getString("cor"),
                        rs.getDouble("tamanho"),
                        rs.getString("material")
                );
                barcos.add(barco);
            }
            return barcos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public java.util.List<Barco> getBarcosById(int id) {
        String query = "SELECT * FROM TCA_Barcos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                java.util.List<Barco> barcos = new java.util.ArrayList<>();
                while (rs.next()) {
                    Barco barco = new Barco(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("tipo"),
                            rs.getString("cor"),
                            rs.getDouble("tamanho"),
                            rs.getString("material")
                    );
                    barcos.add(barco);
                }
                return barcos;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
