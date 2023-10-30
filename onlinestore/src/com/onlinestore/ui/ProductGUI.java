package com.onlinestore.ui;
import javax.swing.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 
 
 class Product {
    private String name;
    private double price;
    private String category;
 
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
 
    public String getName() {
        return name;
    }
 
    public double getPrice() {
        return price;
    }
 
    public String getCategory() {
        return category;
    }
}
 
 public class ProductGUI {
     private JFrame frame;
     private JTextField nameField;
     private JTextField priceField;
     private JTextField categoryField;
 
     public ProductGUI() {
         frame = new JFrame("Product Entry");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(300, 200);
 
         JPanel panel = new JPanel();
         frame.add(panel);
         placeComponents(panel);
 
         frame.setVisible(true);
     }
 
     private void placeComponents(JPanel panel) {
         panel.setLayout(null);
 
         JLabel nameLabel = new JLabel("Name:");
         nameLabel.setBounds(20, 30, 80, 25);
         panel.add(nameLabel);
 
         nameField = new JTextField(20);
         nameField.setBounds(100, 30, 165, 25);
         panel.add(nameField);
 
         JLabel priceLabel = new JLabel("Price:");
         priceLabel.setBounds(20, 60, 80, 25);
         panel.add(priceLabel);
 
         priceField = new JTextField(20);
         priceField.setBounds(100, 60, 165, 25);
         panel.add(priceField);
 
         JLabel categoryLabel = new JLabel("Category:");
         categoryLabel.setBounds(20, 90, 80, 25);
         panel.add(categoryLabel);
 
         categoryField = new JTextField(20);
         categoryField.setBounds(100, 90, 165, 25);
         panel.add(categoryField);
 
         JButton addButton = new JButton("Add Product");
         addButton.setBounds(100, 120, 120, 25);
         panel.add(addButton);
 
         // Add action listener to the button
         addButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String name = nameField.getText();
                 double price = Double.parseDouble(priceField.getText());
                 String category = categoryField.getText();
 
                 // Create a Product object with the entered data
                 Product product = new Product(name, price, category);
 
                 // Perform operations with the Product object, e.g., store it in a list, database, etc.
                 // For this example, let's just print the details
                 System.out.println("Product Added: " + product.getName() +
                                    ", Price: " + product.getPrice() +
                                    ", Category: " + product.getCategory());
             }
         });
     }
 
     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 new ProductGUI();
             }
         });
     }
 }