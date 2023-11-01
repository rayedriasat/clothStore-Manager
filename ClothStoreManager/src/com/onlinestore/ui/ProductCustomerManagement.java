package com.onlinestore.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ProductCustomerManagement {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public ProductCustomerManagement() {
        frame = new JFrame("Product and Customer Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); // Fixed window size

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create and add different views (JPanels)
        cardPanel.add(new LaunchPanel(), "LaunchPanel");
        cardPanel.add(new ProductPanel(), "ProductPanel");
        cardPanel.add(new CustomerPanel(), "CustomerPanel");
        cardPanel.add(new ShoePanel(), "ShoePanel");
        cardPanel.add(new ClothPanel(), "ClothPanel");

        frame.add(cardPanel);
        frame.setVisible(true);
    }

    class LaunchPanel extends JPanel {
        public LaunchPanel() {
            setLayout(new BorderLayout());
            JPanel buttonPanel = new JPanel();
            Font largerFont = new Font("Bolden", Font.BOLD, 20);
            JRadioButton addProductRadioButton = new JRadioButton("Add Product");
            JRadioButton addCustomerRadioButton = new JRadioButton("Add Customer");
            ButtonGroup radioButtonGroup = new ButtonGroup();
            addProductRadioButton.setFont(largerFont);
            addCustomerRadioButton.setFont(largerFont);
            radioButtonGroup.add(addProductRadioButton);
            radioButtonGroup.add(addCustomerRadioButton);
            JButton backButton = new JButton("Back");
            backButton.setFont(largerFont);
            backButton.addActionListener(e -> cardLayout.show(cardPanel, "LaunchPanel"));
            add(backButton);

            backButton.setFocusable(false);
            buttonPanel.add(addProductRadioButton, BorderLayout.WEST);
            buttonPanel.add(addCustomerRadioButton, BorderLayout.EAST);
            add(buttonPanel, BorderLayout.CENTER);

            addProductRadioButton.addActionListener(e -> cardLayout.show(cardPanel, "ProductPanel"));
            addCustomerRadioButton.addActionListener(e -> cardLayout.show(cardPanel, "CustomerPanel"));
            backButton.setFocusable(false);
            addProductRadioButton.setFocusable(false);
            addCustomerRadioButton.setFocusable(false);
        }
    }

    class ProductPanel extends JPanel {
        public ProductPanel() {
            setLayout(new BorderLayout());
            JPanel buttonPanel = new JPanel();
            Font largerFont = new Font("Bolden", Font.BOLD, 25);
            JRadioButton addShoeRadioButton = new JRadioButton("Add Shoe");
            JRadioButton addClothRadioButton = new JRadioButton("Add Cloth");
            ButtonGroup radioButtonGroup = new ButtonGroup();
            addShoeRadioButton.setFont(largerFont);
            addClothRadioButton.setFont(largerFont);
            radioButtonGroup.add(addShoeRadioButton);
            radioButtonGroup.add(addClothRadioButton);
            
            add(buttonPanel, BorderLayout.CENTER);
            
            addShoeRadioButton.addActionListener(e -> cardLayout.show(cardPanel, "ShoePanel"));
            addClothRadioButton.addActionListener(e -> cardLayout.show(cardPanel, "ClothPanel"));
            JButton backButton = new JButton("Back");
            //backButton.setFont(largerFont);
            backButton.addActionListener(e -> cardLayout.show(cardPanel, "LaunchPanel"));
            //add(backButton);
            backButton.setBackground(Color.LIGHT_GRAY);
            backButton.setForeground(Color.BLUE);
            buttonPanel.add(addShoeRadioButton, BorderLayout.WEST);
            buttonPanel.add(addClothRadioButton, BorderLayout.EAST);
            buttonPanel.add(backButton, BorderLayout.PAGE_END);
            backButton.setFocusable(false);
        }
    }

    class CustomerPanel extends JPanel {
        private JTextField nameField, ageField, emailField;

        public CustomerPanel() {
            setLayout(new BorderLayout());
            JPanel inputPanel = new JPanel();
            JPanel buttonPanel = new JPanel();

            JLabel nameLabel = new JLabel("Name:");
            nameField = new JTextField(20);

            JLabel ageLabel = new JLabel("Age:");
            ageField = new JTextField(3);

            JLabel emailLabel = new JLabel("Email:");
            emailField = new JTextField(20);

            inputPanel.setLayout(new GridLayout(3, 2));

            inputPanel.add(nameLabel);
            inputPanel.add(nameField);
            inputPanel.add(ageLabel);
            inputPanel.add(ageField);
            inputPanel.add(emailLabel);
            inputPanel.add(emailField);

            JButton enterButton = new JButton("Enter");
            JButton clearButton = new JButton("Clear");

            buttonPanel.add(enterButton, BorderLayout.WEST);
            buttonPanel.add(clearButton, BorderLayout.EAST);

            enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    int age = 0;
                    try {
                        age = Integer.parseInt(ageField.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(CustomerPanel.this, "Invalid age input. Please enter a valid number.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String email = emailField.getText();

                    boolean additionSuccessful = true; // Replace with your logic

                    if (additionSuccessful) {
                        JOptionPane.showMessageDialog(CustomerPanel.this, "Customer added successfully!", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(CustomerPanel.this, "Failed to add Customer. Please try again.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nameField.setText("");
                    ageField.setText("");
                    emailField.setText("");
                }
            });
            JButton backButton = new JButton("Back");
           
            backButton.addActionListener(e -> cardLayout.show(cardPanel, "LaunchPanel"));
            

            backButton.setFocusable(false);
            backButton.setBackground(Color.DARK_GRAY);
            backButton.setForeground(Color.WHITE);
            add(inputPanel, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);
            add(backButton, BorderLayout.PAGE_START);
            
            
        }
    }

    class ShoePanel extends JPanel {
        private JTextField nameField, priceField, sizeField, brandField;

        public ShoePanel() {
            setLayout(new BorderLayout());
            JPanel inputPanel = new JPanel();
            JPanel buttonPanel = new JPanel();

            JLabel nameLabel = new JLabel("Name:");
            nameField = new JTextField(20);

            JLabel priceLabel = new JLabel("Price:");
            priceField = new JTextField(10);

            JLabel sizeLabel = new JLabel("Size:");
            sizeField = new JTextField(5);

            JLabel brandLabel = new JLabel("Brand:");
            brandField = new JTextField(20);

            inputPanel.setLayout(new GridLayout(4, 2));

            inputPanel.add(nameLabel);
            inputPanel.add(nameField);
            inputPanel.add(priceLabel);
            inputPanel.add(priceField);
            inputPanel.add(sizeLabel);
            inputPanel.add(sizeField);
            inputPanel.add(brandLabel);
            inputPanel.add(brandField);

            JButton enterButton = new JButton("Enter");
            JButton clearButton = new JButton("Clear");

            buttonPanel.add(enterButton, BorderLayout.WEST);
            buttonPanel.add(clearButton, BorderLayout.EAST);

            enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    double price = 0.0;
                    try {
                        price = Double.parseDouble(priceField.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(ShoePanel.this, "Invalid price input. Please enter a valid number.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String size = sizeField.getText();
                    String brand = brandField.getText();

                    boolean additionSuccessful = true; // Replace with your logic

                    if (additionSuccessful) {
                        JOptionPane.showMessageDialog(ShoePanel.this, "Shoe added successfully!", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(ShoePanel.this, "Failed to add Shoe. Please try again.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nameField.setText("");
                    priceField.setText("");
                    sizeField.setText("");
                    brandField.setText("");
                }
            });

            add(inputPanel, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);
            JButton backButton = new JButton("Back");
           
            backButton.addActionListener(e -> cardLayout.show(cardPanel, "LaunchPanel"));
            backButton.setBackground(Color.DARK_GRAY);
            backButton.setForeground(Color.WHITE);
            
            add(backButton,BorderLayout.PAGE_START);

            backButton.setFocusable(false);
        }
    }

    class ClothPanel extends JPanel {
        private JTextField nameField, priceField, sizeField, materialField;

        public ClothPanel() {
            setLayout(new BorderLayout());
            JPanel inputPanel = new JPanel();
            JPanel buttonPanel = new JPanel();

            JLabel nameLabel = new JLabel("Name:");
            nameField = new JTextField(20);

            JLabel priceLabel = new JLabel("Price:");
            priceField = new JTextField(10);

            JLabel sizeLabel = new JLabel("Size:");
            sizeField = new JTextField(5);

            JLabel materialLabel = new JLabel("Material:");
            materialField = new JTextField(20);

            inputPanel.setLayout(new GridLayout(4, 2));

            inputPanel.add(nameLabel);
            inputPanel.add(nameField);
            inputPanel.add(priceLabel);
            inputPanel.add(priceField);
            inputPanel.add(sizeLabel);
            inputPanel.add(sizeField);
            inputPanel.add(materialLabel);
            inputPanel.add(materialField);

            JButton enterButton = new JButton("Enter");
            JButton clearButton = new JButton("Clear");

            buttonPanel.add(enterButton, BorderLayout.WEST);
            buttonPanel.add(clearButton, BorderLayout.EAST);

            enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    double price = 0.0;
                    try {
                        price = Double.parseDouble(priceField.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(ClothPanel.this, "Invalid price input. Please enter a valid number.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String size = sizeField.getText();
                    String material = materialField.getText();

                    boolean additionSuccessful = true; // Replace with your logic

                    if (additionSuccessful) {
                        JOptionPane.showMessageDialog(ClothPanel.this, "Cloth added successfully!", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(ClothPanel.this, "Failed to add Cloth. Please try again.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nameField.setText("");
                    priceField.setText("");
                    sizeField.setText("");
                    materialField.setText("");
                }
            });
            JButton backButton = new JButton("Back");
            
            backButton.addActionListener(e -> cardLayout.show(cardPanel, "LaunchPanel"));
            backButton.setBackground(Color.DARK_GRAY);
            backButton.setForeground(Color.WHITE);
            add(inputPanel, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);
            add(backButton, BorderLayout.NORTH);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductCustomerManagement());
    }
}