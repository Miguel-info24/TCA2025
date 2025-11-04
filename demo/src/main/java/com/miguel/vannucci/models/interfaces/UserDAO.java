    package com.miguel.vannucci.models.interfaces;

    import java.util.List;

    import com.miguel.vannucci.models.User;

    public interface UserDAO {
        void addUser(User user);
        boolean updateUser(User user);
        boolean deleteUser(int userId);
        List<User> getAllUsers();
        User getUserById(int userId);
        User getUserByEmail(String email);
        User getUserByEmailAndPassword(String email, String password);
    }
