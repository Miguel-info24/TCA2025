package com.miguel.vannucci.DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.miguel.vannucci.database.FabricaConexoes;
import com.miguel.vannucci.models.Pedido;
import com.miguel.vannucci.models.interfaces.pedidoDAO;

public class DAOsPedidoImpl implements pedidoDAO {

    private static final Connection connection = FabricaConexoes.getInstance().getConnection();

    @Override
    public int addPedido(int idUser, String descricao, double preco, String status, LocalDate dataInicio, LocalDate dataFim, int idBarco) {
        String query = "INSERT INTO TCA_Barcos_pedido (idUser, descricao_pedido, preco, status_pedido, data_inicio, data_fim, id_Barco) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idUser);
            stmt.setString(2, descricao);
            stmt.setDouble(3, preco);
            stmt.setString(4, status);
            stmt.setDate(5, Date.valueOf(dataInicio));
            stmt.setDate(6, Date.valueOf(dataFim));
            stmt.setInt(7, idBarco);
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean deletePedido(int idPedido) {
        String query = "DELETE FROM TCA_Barcos_pedido WHERE id_pedido = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idPedido);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updatePedido(int id, String descricao, double preco, String status, LocalDate dataInicio, LocalDate dataFim) {
        String query = "UPDATE TCA_Barcos_pedido SET descricao_pedido = ?, preco = ?, status_pedido = ?, data_inicio = ?, data_fim = ? WHERE id_pedido = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, descricao);
            stmt.setDouble(2, preco);
            stmt.setString(3, status);
            stmt.setDate(4, Date.valueOf(dataInicio));
            stmt.setDate(5, Date.valueOf(dataFim));
            stmt.setInt(6, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Pedido> getPedidos() {
        String query = "SELECT * FROM TCA_Barcos_pedido";
        List<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                pedidos.add(mapResultSetToPedido(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    @Override
    public Pedido getPedidoById(int idPedido) {
        String query = "SELECT * FROM TCA_Barcos_pedido WHERE id_pedido = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idPedido);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToPedido(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Pedido> getPedidosByUserId(int idUser) {
        String query = "SELECT * FROM TCA_Barcos_pedido WHERE idUser = ?";
        List<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idUser);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pedidos.add(mapResultSetToPedido(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    @Override
    public int getIdUser() {
        String query = "SELECT idUser FROM TCA_Barcos_pedido LIMIT 1";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("idUser");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getNextId() {
        String query = "SELECT COALESCE(MAX(id_pedido), 0) + 1 AS next_id FROM TCA_Barcos_pedido";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("next_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    private Pedido mapResultSetToPedido(ResultSet rs) throws Exception {
        return new Pedido(
                rs.getInt("id_pedido"),
                rs.getInt("idUser"),
                rs.getString("descricao_pedido"),
                rs.getDouble("preco"),
                rs.getString("status_pedido"),
                rs.getDate("data_inicio").toLocalDate(),
                rs.getDate("data_fim").toLocalDate(),
                null
        );
    }
}
