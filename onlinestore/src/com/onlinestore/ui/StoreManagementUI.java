package com.onlinestore.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreManagementUI {
    private JFrame mainFrame;
    private JPanel loginPanel;
    private JPanel storePanel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public StoreManagementUI() {
        mainFrame = new JFrame("Online Store Management System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new CardLayout());

        createLoginPanel();
        createStorePanel();

        mainFrame.add(loginPanel, "login");
        mainFrame.add(storePanel, "store");

        // Show the login panel initially
        CardLayout cardLayout = (CardLayout) mainFrame.getContentPane().getLayout();
        cardLayout.show(mainFrame.getContentPane(), "login");
    }

    private void createLoginPanel() {
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 1));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check login credentials (username and password)
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                // Perform authentication, e.g., check against a database or hardcoded values
                if (authenticate(username, password)) {
                    // Show the store panel if authentication is successful
                    CardLayout cardLayout = (CardLayout) mainFrame.getContentPane().getLayout();
                    cardLayout.show(mainFrame.getContentPane(), "store");
                } else {
                    // Display an error message for failed login
                    JOptionPane.showMessageDialog(loginPanel, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
    }

    private void createStorePanel() {
        storePanel = new JPanel();
        storePanel.setLayout(new GridLayout(3, 1));

        // Create components for store functionality (e.g., add products, create orders, edit customer details)

        JButton addProductButton = new JButton("Add Product");
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to add a product
                // You can display forms to enter product details and call the appropriate methods
            }
        });

        JButton createOrderButton = new JButton("Create Order");
        createOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to create an order
                // You can display forms to select products and enter order details
            }
        });

        storePanel.add(addProductButton);
        storePanel.add(createOrderButton);
    }

    public void display() {
        mainFrame.setVisible(true);
    }

    private boolean authenticate(String username, char[] password) {
        // Implement authentication logic here
        // You can check against a database, hardcoded values, or any authentication method
        // Return true if authentication is successful, false otherwise (for this example, we use hardcoded values)
        return username.equals("admin") && new String(password).equals("password");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StoreManagementUI storeUI = new StoreManagementUI();
            storeUI.display();
        });
    }
}
