    package com.miguel.vannucci.models.interfaces;

    import java.util.List;

    import com.miguel.vannucci.models.User;

    public interface UserDAO {
        int addUser(User user);
        boolean updateUser(User user);
        boolean deleteUser(int userId);
        List<User> getAllUsers();
        User getUserById(int userId);

        // novos métodos para login e busca
        User getUserByEmail(String email);
        User getUserByEmailAndPassword(String email, String password);
    }
