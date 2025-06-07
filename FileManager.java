/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io;

import model.User;

import java.io.*;
import java.util.*;

/**
 * FileManager handles all file operations for users and transactions.
 */
public class FileManager {

    private static final String USER_FILE = "users.txt";
    private static final String BALANCE_SUFFIX = "_balance.txt";

    /**
     * Load all users with their passwords.
     * @return Map of username to password
     */
    public static Map<String, String> loadUsers() {
        Map<String, String> users = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    users.put(data[0], data[1]);
                }
            }
        } catch (IOException e) {
            // File may not exist yet, that's fine
        }
        return users;
    }

    /**
     * Save a new user with username and password.
     * @param username
     * @param password
     */
    public static void saveUser(String username, String password) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            bw.write(username + "," + password);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error saving user: " + e.getMessage());
        }
    }

    /**
     * Check if a user exists.
     * @param username
     * @return 
     */
    public static boolean userExists(String username) {
        return loadUsers().containsKey(username);
    }

    /**
     * Update user credentials and balance atomically.
     * @param user
     */
    public static void updateUser(User user) {
        // Update user password in users.txt
        Map<String, String> users = loadUsers();
        users.put(user.getUsername(), user.getPassword());
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error updating user file: " + e.getMessage());
        }
        // Save balance separately
        saveBalance(user.getUsername(), user.getBalance());
    }

    /**
     * Save balance for a user in separate file.
     */
    public static void saveBalance(String username, double balance) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(username + BALANCE_SUFFIX))) {
            bw.write(String.valueOf(balance));
        } catch (IOException e) {
            System.err.println("Error saving balance: " + e.getMessage());
        }
    }

    /**
     * Load balance for a user.Returns 0 if no balance file.
     * @param username
     * @return 
     */
    public static double loadBalance(String username) {
        String file = username + BALANCE_SUFFIX;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            if (line != null) {
                return Double.parseDouble(line);
            }
        } catch (IOException | NumberFormatException e) {
            // No file or invalid balance, default 0
        }
        return 0.0;
    }

    /**
     * Append a transaction line to user's transaction file.
     * @param file
     * @param line
     */
    public static void appendLine(String file, String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error appending transaction: " + e.getMessage());
        }
    }

    /**
     * Read all lines from a file.
     * @param file
     * @return 
     */
    public static List<String> readLines(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            // File may not exist; return empty list
        }
        return lines;
    }
}

