/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.UserDAO;
import io.FileManager;
import model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Core service class handling banking operations and UI flow.
 */
public class BankService {
    private final Scanner sc = new Scanner(System.in);
    private User currentUser;

    /**
     * Start the banking app console interface.
     */
    public void start() {
        OUTER:
        while (true) {
            System.out.println("\n===== Online Banking System =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = getIntInput();
            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Goodbye!");
                    break OUTER;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Register a new user.
     */
    private void register() {
        System.out.print("Enter username: ");
        String username = sc.nextLine().trim();
        if (username.isEmpty() || username.contains(",")) {
            System.out.println("Invalid username. Cannot be empty or contain commas.");
            return;
        }

        System.out.print("Enter password: ");
        String password = sc.nextLine().trim();
        if (password.isEmpty()) {
            System.out.println("Password cannot be empty.");
            return;
        }

        User newUser = new User(username, password, 0.0);
        if (!UserDAO.registerUser(newUser)) {
            System.out.println("Username already exists. Try a different one.");
        } else {
            System.out.println("Registration successful! You can now login.");
        }
    }

    /**
     * User login flow.
     */
    private void login() {
        System.out.print("Username: ");
        String username = sc.nextLine().trim();
        System.out.print("Password: ");
        String password = sc.nextLine().trim();

        User user = UserDAO.findUser(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
            dashboard();
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    /**
     * Dashboard after login to perform banking operations.
     */
    private void dashboard() {
        while (true) {
            System.out.println("\n--- Dashboard ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transactions");
            System.out.println("5. Logout");
            System.out.print("Choose: ");
            int choice = getIntInput();

            switch (choice) {
                case 1 -> System.out.printf("Current Balance: $%.2f%n", currentUser.getBalance());
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> showTransactions();
                case 5 -> {
                    System.out.println("Logging out...");
                    currentUser = null;
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * Deposit money to user account.
     */
    private void deposit() {
        System.out.print("Amount to deposit: ");
        double amount = getDoubleInput();
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        currentUser.setBalance(currentUser.getBalance() + amount);
        UserDAO.updateUser(currentUser);
        recordTransaction("Deposit", amount);
        System.out.println("Deposit successful.");
    }

    /**
     * Withdraw money from user account.
     */
    private void withdraw() {
        System.out.print("Amount to withdraw: ");
        double amount = getDoubleInput();
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        if (amount > currentUser.getBalance()) {
            System.out.println("Insufficient funds.");
            return;
        }
        currentUser.setBalance(currentUser.getBalance() - amount);
        UserDAO.updateUser(currentUser);
        recordTransaction("Withdraw", amount);
        System.out.println("Withdrawal successful.");
    }

    /**
     * Record a transaction with timestamp.
     */
    private void recordTransaction(String type, double amount) {
        String file = "transactions_" + currentUser.getUsername() + ".txt";
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String record = String.format("%s: %s $%.2f", timestamp, type, amount);
        FileManager.appendLine(file, record);
    }

    /**
     * Show all transactions for current user.
     */
    private void showTransactions() {
        String file = "transactions_" + currentUser.getUsername() + ".txt";
        List<String> transactions = FileManager.readLines(file);
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("--- Transaction History ---");
            transactions.forEach(System.out::println);
        }
    }

    /**
     * Utility method to get integer input safely.
     */
    private int getIntInput() {
        while (true) {
            String input = sc.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input, please enter a number: ");
            }
        }
    }

    /**
     * Utility method to get double input safely.
     */
    private double getDoubleInput() {
        while (true) {
            String input = sc.nextLine();
            try {
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid amount, please enter a valid number: ");
            }
        }
    }
}
