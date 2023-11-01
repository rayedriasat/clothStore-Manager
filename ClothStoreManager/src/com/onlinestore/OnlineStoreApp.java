package com.onlinestore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Don't know about this code, maybe we have to forget about this and freshly create a GUI for our system
public class OnlineStoreApp {
    private JFrame mainFrame;
    private JPanel slideMenuPanel;
    private JPanel contentPanel;
    private JLabel backgroundLabel;

    public OnlineStoreApp() {
        mainFrame = new JFrame("Online Store Management System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);
        mainFrame.setLayout(new BorderLayout());

        // Background Image
        ImageIcon backgroundImage = new ImageIcon("background.jpg");
        backgroundLabel = new JLabel(backgroundImage);
        mainFrame.setContentPane(backgroundLabel);

        // Slide Menu
        slideMenuPanel = new JPanel();
        slideMenuPanel.setBackground(Color.DARK_GRAY);
        slideMenuPanel.setPreferredSize(new Dimension(200, mainFrame.getHeight()));
        slideMenuPanel.setLayout(new BoxLayout(slideMenuPanel, BoxLayout.PAGE_AXIS));

        JButton placeOrderButton = createMenuItem("Place Order");
        JButton viewOrdersButton = createMenuItem("See Existing Orders");

        slideMenuPanel.add(placeOrderButton);
        slideMenuPanel.add(viewOrdersButton);

        // Content Panel
        contentPanel = new JPanel();
        contentPanel.setOpaque(false);

        mainFrame.add(slideMenuPanel, BorderLayout.WEST);
        mainFrame.add(contentPanel, BorderLayout.CENTER);

        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement code to switch to the "Place Order" section
            }
        });

        viewOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement code to switch to the "See Existing Orders" section
            }
        });
    }

    private JButton createMenuItem(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        return button;
    }

    public void display() {
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OnlineStoreApp storeApp = new OnlineStoreApp();
            storeApp.display();
        });
    }
}
