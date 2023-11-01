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

        
        CardLayout cardLayout = (CardLayout) mainFrame.getContentPane().getLayout();
        cardLayout.show(mainFrame.getContentPane(), "login");
    }

    private void createLoginPanel() {
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(4, 1));

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

               
                if (authenticate(username, password)) {
                	ProductCustomerManagement startUi = new ProductCustomerManagement();
                    mainFrame.dispose();
                } else {
                  
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

        
        JButton addProductButton = new JButton("Add Product");
        addProductButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Create an instance of ProductCustomerManagement
                ProductCustomerManagement productManagement = new ProductCustomerManagement();
                CardLayout cardLayout = (CardLayout) mainFrame.getContentPane().getLayout();
                cardLayout.show(mainFrame.getContentPane(), "store");
                
            }
        });


    }

    public void display() {
        mainFrame.setVisible(true);
    }

    private boolean authenticate(String username, char[] password) {
        
        return username.equals("admin") && new String(password).equals("password");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StoreManagementUI storeUI = new StoreManagementUI();
            storeUI.display();
        });
    }
}
