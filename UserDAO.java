/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.User;
import io.FileManager;

/**
 * Data Access Object for User-related operations.
 */
public class UserDAO {

    /**
     * Finds a user by username.
     * @param username the username to find
     * @return User object if found; otherwise null
     */
    public static User findUser(String username) {
        // Load all users from file
        var users = FileManager.loadUsers();
        if (users.containsKey(username)) {
            String password = users.get(username);
            // Load balance from a user-specific file (if exists), else 0
            double balance = FileManager.loadBalance(username);
            return new User(username, password, balance);
        }
        return null;
    }

    /**
     * Updates the user data (password and balance).
     * @param user the user to update
     */
    public static void updateUser(User user) {
        FileManager.updateUser(user);
    }

    /**
     * Registers a new user.
     * @param user User object
     * @return true if registration successful, false if username exists
     */
    public static boolean registerUser(User user) {
        if (FileManager.userExists(user.getUsername())) {
            return false; // User exists already
        }
        FileManager.saveUser(user.getUsername(), user.getPassword());
        FileManager.saveBalance(user.getUsername(), user.getBalance());
        return true;
    }
}
