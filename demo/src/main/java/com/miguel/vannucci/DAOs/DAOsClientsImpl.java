package com.miguel.vannucci.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.miguel.vannucci.database.FabricaConexoes;
import com.miguel.vannucci.models.Client;
import com.miguel.vannucci.models.interfaces.ClientDAO;

public class DAOsClientsImpl implements ClientDAO {
    
    private static final Connection connection = FabricaConexoes.getInstance().getConnection();
    @Override
    public int addClient(Client client) {
        String query = "INSERT INTO TCA_Barcos_Client (idCliente) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, client.getId());
            stmt.execute();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean updateClient(Client client) {

        String query = "UPDATE TCA_Barcos_Client SET idCliente = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, client.getId());
            stmt.setInt(2, client.getId());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteClient(int clientId) {
        String query = "DELETE FROM TCA_Barcos_Client WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, clientId);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Client getClientById(int clientId) {
        
        String query = "SELECT * FROM TCA_Barcos_Client WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, clientId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return mapResultSetToClient(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public java.util.List<Client> getClients() {
        String query = "SELECT * FROM TCA_Barcos_Client";
        java.util.List<Client> clients = new java.util.ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clients.add(mapResultSetToClient(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    

    private Client mapResultSetToClient(ResultSet rs) {
        Client client = new Client();
        try {
            client.setId(rs.getInt("idCliente"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
