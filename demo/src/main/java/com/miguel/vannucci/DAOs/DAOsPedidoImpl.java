package com.miguel.vannucci.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.Date;
import com.miguel.vannucci.database.FabricaConexoes;
import com.miguel.vannucci.models.Pedido;
import com.miguel.vannucci.models.interfaces.pedidoDAO;

public class DAOsPedidoImpl implements pedidoDAO {
    
    private static final Connection connection = FabricaConexoes.getInstance().getConnection();

    @Override
    public int addPedido(int id, String descricao, double preco, String status, LocalDate dataInicio, LocalDate dataFim) {
        String query = "INSERT INTO TCA_Barcos_Pedido (id, descricao, preco, status, dataInicio, dataFim) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, descricao);
            stmt.setDouble(3, preco);
            stmt.setString(4, status);
            stmt.setDate(5, Date.valueOf(dataInicio));
            stmt.setDate(6, Date.valueOf(dataFim));
            stmt.execute();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean deletePedido(int idPedido) {
        String query = "DELETE FROM TCA_Barcos_Pedido WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idPedido);
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePedido(int id, String descricao, double preco, String status, LocalDate dataInicio, LocalDate dataFim) {
        String query = "UPDATE TCA_Barcos_Pedido SET descricao = ?, status = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, descricao);
            stmt.setDouble(3, preco);
            stmt.setString(4, status);
            stmt.setDate(5, Date.valueOf(dataInicio));
            stmt.setDate(6, Date.valueOf(dataFim));

            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public java.util.List<Pedido> getPedidos() {
        String query = "SELECT * FROM TCA_Barcos_Pedido";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            java.util.List<Pedido> pedidos = new java.util.ArrayList<>();
            while (rs.next()) {
                Pedido pedido = new Pedido(
                    rs.getInt("id"),
                    rs.getString("descricao"),
                    rs.getDouble("preco"),
                    rs.getString("status"),
                    rs.getDate("dataInicio").toLocalDate(),
                    rs.getDate("dataFim").toLocalDate(),
                    null
                );
                pedidos.add(pedido);
            }
            return pedidos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Pedido getPedidoById(int idPedido) {
        String query = "SELECT * FROM TCA_Barcos_Pedido WHERE id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idPedido);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pedido(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getDouble("preco"),
                        rs.getString("status"),
                        rs.getDate("dataInicio").toLocalDate(),
                        rs.getDate("dataFim").toLocalDate(),
                        null
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public java.util.List<Pedido> getPedidosByClient(int idClient) {
        String query = "SELECT * FROM TCA_Barcos_Pedido WHERE idClient = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idClient);
            try (ResultSet rs = stmt.executeQuery()) {
                java.util.List<Pedido> pedidos = new java.util.ArrayList<>();
                while (rs.next()) {
                    Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getDouble("preco"),
                        rs.getString("status"),
                        rs.getDate("dataInicio").toLocalDate(),
                        rs.getDate("dataFim").toLocalDate(),
                        null
                    );
                    pedidos.add(pedido);
                }
                return pedidos;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return null;
    }

    @Override
    public java.util.List<Pedido> getPedidosByCarpinteiro(int idCarpinteiro) {
        String query = "SELECT * FROM TCA_Barcos_Pedido WHERE idCarpinteiro = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idCarpinteiro);
            try (ResultSet rs = stmt.executeQuery()) {
                java.util.List<Pedido> pedidos = new java.util.ArrayList<>();
                while (rs.next()) {
                    Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getDouble("preco"),
                        rs.getString("status"),
                        rs.getDate("dataInicio").toLocalDate(),
                        rs.getDate("dataFim").toLocalDate(),
                        null
                    );
                    pedidos.add(pedido);
                }
                return pedidos;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
