package com.miguel.vannucci.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.miguel.vannucci.database.FabricaConexoes;
import com.miguel.vannucci.models.User;
import com.miguel.vannucci.models.interfaces.UserDAO;

public class DAOsUsersImpl implements UserDAO {

    private static final Connection connection = FabricaConexoes.getInstance().getConnection();


    @Override
    public int addUser(User user) {
        String query = "INSERT INTO TCA_Barcos_User (cpf, nome, email, senha, phone, tipo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getCpf());
            System.out.println("Cpf" + user.getCpf());
            stmt.setString(2, user.getName());
            System.out.println("Name" + user.getName());
            stmt.setString(3, user.getEmail());
            System.out.println("Email" + user.getEmail());
            stmt.setString(4, user.getPassword());
            System.out.println("Password" + user.getPassword());
            stmt.setString(5, user.getPhone());
            System.out.println("Phone" + user.getPhone());
            stmt.setString(6, user.getType());
            System.out.println("Type" + user.getType());
            stmt.execute();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean updateUser(User user) {
        String query = "UPDATE TCA_Barcos_User SET name = ?, email = ?, password = ?, cpf = ?, phone = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getCpf());
            stmt.setString(5, user.getPhone());
            stmt.setInt(6, user.getId());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int userId) {
        String query = "DELETE FROM TCA_Barcos_User WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> TCA_Barcos_User = new ArrayList<>();
        String query = "SELECT * FROM TCA_Barcos_User";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TCA_Barcos_User.add(mapResultSetToUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return TCA_Barcos_User;
    }

    @Override
    public User getUserById(int userId) {
        String query = "SELECT * FROM TCA_Barcos_User WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return mapResultSetToUser(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        String query = "SELECT * FROM TCA_Barcos_User WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return mapResultSetToUser(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        String query = "SELECT * FROM TCA_Barcos_User WHERE email = ? AND senha = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
             return mapResultSetToUser(rs);
            }    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("idUser"));
        user.setName(rs.getString("nome"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("senha"));
        user.setCpf(rs.getString("cpf"));
        user.setPhone(rs.getString("phone"));
        user.setType(rs.getString("tipo"));
        return user;
    }
}
