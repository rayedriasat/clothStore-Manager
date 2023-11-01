package admin.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.onlinestore.OnlineStoreManagementSystem;
import com.onlinestore.model.*;
import com.onlinestore.exeptions.*;

public class HomePage extends JFrame implements ActionListener {
	private static OnlineStoreManagementSystem store1;
	private Order order;
	private JButton addCustomerButton, addProductButton, addClothButton, addOrderButton, searchButton,
			editButton, deleteButton, showAllButton, showCustomerButton, showOrderButton;
	private JPanel clothInputPanel, customerInputPanel, orderInputPanel;
	private DefaultTableModel productTableModel, customerTableModel, orderTableModel;
	private JTable productTable, customerTable, orderTable;
	private JScrollPane productScrollPane, customerScrollPane, orderScrollPane;
	private JPanel searchPanel;

	HomePage() {
		store1 = new OnlineStoreManagementSystem();
		store1 = OnlineStoreManagementSystem.loadDataFromFile("data.bin");

		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image1 = new JLabel(i3);
		image1.setBounds(0, 0, 1120, 630);
		add(image1);

		// Label
		JLabel headerJLabel = new JLabel("Main Page");
		headerJLabel.setForeground(Color.white);
		headerJLabel.setBounds(650, 20, 400, 40);
		headerJLabel.setFont(new Font("Serif", Font.BOLD, 40));
		image1.add(headerJLabel);

		// Button for add product
		addProductButton = new JButton("Add Product");
		addProductButton.setBounds(650, 80, 150, 40);
		addProductButton.addActionListener(this);
		image1.add(addProductButton);

		// Button for add customer
		addCustomerButton = new JButton("Add Customer");
		addCustomerButton.setBounds(820, 80, 150, 40);
		addCustomerButton.addActionListener(this);
		image1.add(addCustomerButton);

		// Button for add order
		addOrderButton = new JButton("Add new order");
		addOrderButton.setBounds(650, 140, 150, 40);
		addOrderButton.addActionListener(this);
		image1.add(addOrderButton);

		// Button for search
		searchButton = new JButton("Search Product");
		searchButton.setBounds(820, 140, 150, 40);
		searchButton.addActionListener(this);
		image1.add(searchButton);

		// Button for delete
		deleteButton = new JButton("Delete Menu");
		deleteButton.setBounds(650, 200, 150, 40);
		deleteButton.addActionListener(this);
		image1.add(deleteButton);

		// Button for edit
		editButton = new JButton("Edit Menu");
		editButton.setBounds(820, 200, 150, 40);
		editButton.addActionListener(this);
		image1.add(editButton);

		// Button for show all
		showAllButton = new JButton("Show all Products");
		showAllButton.setBounds(650, 260, 150, 40);
		showAllButton.addActionListener(this);
		image1.add(showAllButton);

		// Button for show all customer
		showCustomerButton = new JButton("Show all Customers");
		showCustomerButton.setBounds(820, 260, 150, 40);
		showCustomerButton.addActionListener(this);
		image1.add(showCustomerButton);

		// Button for show all order
		showOrderButton = new JButton("Show Orders");
		showOrderButton.setBounds(650, 320, 150, 40);
		showOrderButton.addActionListener(this);
		image1.add(showOrderButton);

		// Cloth Input Panel
		clothInputPanel = new JPanel();
		clothInputPanel.setLayout(null);
		clothInputPanel.setBounds(310, 60, 300, 300);
		clothInputPanel.setVisible(false);

		JLabel clothNameLabel = new JLabel("Name:");
		clothNameLabel.setBounds(10, 10, 100, 20);
		clothInputPanel.add(clothNameLabel);

		JTextField clothNameField = new JTextField();
		clothNameField.setBounds(120, 10, 150, 20);
		clothInputPanel.add(clothNameField);

		JLabel clothPriceLabel = new JLabel("Price:");
		clothPriceLabel.setBounds(10, 40, 100, 20);
		clothInputPanel.add(clothPriceLabel);

		JTextField clothPriceField = new JTextField();
		clothPriceField.setBounds(120, 40, 150, 20);
		clothInputPanel.add(clothPriceField);

		JLabel clothSizeLabel = new JLabel("Size:");
		clothSizeLabel.setBounds(10, 70, 100, 20);
		clothInputPanel.add(clothSizeLabel);

		JTextField clothSizeField = new JTextField();
		clothSizeField.setBounds(120, 70, 150, 20);
		clothInputPanel.add(clothSizeField);

		JLabel clothMaterialLabel = new JLabel("Material:");
		clothMaterialLabel.setBounds(10, 100, 100, 20);
		clothInputPanel.add(clothMaterialLabel);

		JTextField clothMaterialField = new JTextField();
		clothMaterialField.setBounds(120, 100, 150, 20);
		clothInputPanel.add(clothMaterialField);

		JLabel clothInStockLabel = new JLabel("In Stock:");
		clothInStockLabel.setBounds(10, 130, 100, 20);
		clothInputPanel.add(clothInStockLabel);

		JCheckBox clothInStockCheckBox = new JCheckBox("Yes");
		clothInStockCheckBox.setBounds(120, 130, 50, 20);
		clothInStockCheckBox.setSelected(true);
		clothInputPanel.add(clothInStockCheckBox);

		JButton clearClothButton = new JButton("Clear");
		clearClothButton.setBounds(10, 160, 100, 30);
		clothInputPanel.add(clearClothButton);

		JButton enterClothButton = new JButton("Enter");
		enterClothButton.setBounds(150, 160, 100, 30);
		clothInputPanel.add(enterClothButton);

		clothNameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
                    clothPriceField.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        clothPriceField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
                    clothSizeField.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        clothSizeField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
                    clothMaterialField.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        clothMaterialField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
                    clothInStockCheckBox.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        clothInStockCheckBox.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
                    enterClothButton.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });   
        
        enterClothButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
                	// Get values from cloth input fields
    				String name = clothNameField.getText();
    				String priceStr = clothPriceField.getText();
    				double price = 0.0;
    				if (!priceStr.equals("")) price = Double.parseDouble(priceStr);
    				String size = clothSizeField.getText();
    				String material = clothMaterialField.getText();
    				boolean inStock = clothInStockCheckBox.isSelected();

    				// Create a Cloth object with the entered values
    				Cloth newCloth = new Cloth(name, price, size, material, inStock);

    				store1.addCloth(newCloth);

    				JOptionPane.showMessageDialog(clothInputPanel, "Cloth added successfully!", "Success",
    						JOptionPane.INFORMATION_MESSAGE);
    				showProductTable();
    				productScrollPane.setVisible(true);
    				customerScrollPane.setVisible(false);
    				orderScrollPane.setVisible(false);
    				// Clear the input fields after a successful addition
    				clothNameField.setText("");
    				clothPriceField.setText("");
    				clothSizeField.setText("");
    				clothMaterialField.setText("");
    				clothInStockCheckBox.setSelected(false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
		// Add action listeners for the buttons
		clearClothButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clothNameField.setText("");
				clothPriceField.setText("");
				clothSizeField.setText("");
				clothMaterialField.setText("");
				clothInStockCheckBox.setSelected(false);
			}
		});

		enterClothButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get values from cloth input fields
				String name = clothNameField.getText();
				double price = Double.parseDouble(clothPriceField.getText());
				String size = clothSizeField.getText();
				String material = clothMaterialField.getText();
				boolean inStock = clothInStockCheckBox.isSelected();

				// Create a Cloth object with the entered values
				Cloth newCloth = new Cloth(name, price, size, material, inStock);

				store1.addCloth(newCloth);

				JOptionPane.showMessageDialog(clothInputPanel, "Cloth added successfully!", "Success",
						JOptionPane.INFORMATION_MESSAGE);
				showProductTable();
				productScrollPane.setVisible(true);
				customerScrollPane.setVisible(false);
				orderScrollPane.setVisible(false);
				// Clear the input fields after a successful addition
				clothNameField.setText("");
				clothPriceField.setText("");
				clothSizeField.setText("");
				clothMaterialField.setText("");
				clothInStockCheckBox.setSelected(false);
			}
		});
		image1.add(clothInputPanel);
		
		// customerInputPanel
		customerInputPanel = new JPanel();
		customerInputPanel.setLayout(null);
		customerInputPanel.setBounds(300, 80, 300, 300);
		customerInputPanel.setVisible(false);

		JLabel customerNameLabel = new JLabel("Name:");
		customerNameLabel.setBounds(10, 10, 100, 20);
		customerInputPanel.add(customerNameLabel);

		JTextField customerNameField = new JTextField();
		customerNameField.setBounds(120, 10, 150, 20);
		customerInputPanel.add(customerNameField);

		JLabel customerEmailLabel = new JLabel("Email:");
		customerEmailLabel.setBounds(10, 40, 100, 20);
		customerInputPanel.add(customerEmailLabel);

		JTextField customerEmailField = new JTextField();
		customerEmailField.setBounds(120, 40, 150, 20);
		customerInputPanel.add(customerEmailField);

		JLabel customerAgeLabel = new JLabel("Age:");
		customerAgeLabel.setBounds(10, 70, 100, 20);
		customerInputPanel.add(customerAgeLabel);

		JTextField customerAgeField = new JTextField();
		customerAgeField.setBounds(120, 70, 150, 20);
		customerInputPanel.add(customerAgeField);

		JButton clearCustomerButton = new JButton("Clear");
		clearCustomerButton.setBounds(10, 100, 100, 30);
		customerInputPanel.add(clearCustomerButton);

		JButton enterCustomerButton = new JButton("Enter");
		enterCustomerButton.setBounds(150, 100, 100, 30);
		customerInputPanel.add(enterCustomerButton);
		
		// key customer
		customerNameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
                    customerEmailField.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

		customerEmailField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
                    customerAgeField.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        customerAgeField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
                    enterCustomerButton.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });   
        
        enterCustomerButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
                	// Get values from customer input fields
    				String name = customerNameField.getText();
    				String email = customerEmailField.getText();
    				int age = Integer.parseInt(customerAgeField.getText());

    				// Create a Customer object with the entered values
    				Customer newCustomer = new Customer(name, email, age);

    				store1.addCustomer(newCustomer);
    				JOptionPane.showMessageDialog(customerInputPanel, "Customer added successfully!", "Success",
    						JOptionPane.INFORMATION_MESSAGE);
    				showCustomerTable();
    				customerScrollPane.setVisible(true);
    				productScrollPane.setVisible(false);
    				orderScrollPane.setVisible(false);
    				// Clear the input fields after a successful addition
    				customerNameField.setText("");
    				customerEmailField.setText("");
    				customerAgeField.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
		// key customer end
		// Add action listeners for the buttons
		clearCustomerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customerNameField.setText("");
				customerEmailField.setText("");
				customerAgeField.setText("");
			}
		});

		enterCustomerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get values from customer input fields
				String name = customerNameField.getText();
				String email = customerEmailField.getText();
				int age = Integer.parseInt(customerAgeField.getText());

				// Create a Customer object with the entered values
				Customer newCustomer = new Customer(name, email, age);

				store1.addCustomer(newCustomer);
				JOptionPane.showMessageDialog(customerInputPanel, "Customer added successfully!", "Success",
						JOptionPane.INFORMATION_MESSAGE);
				showCustomerTable();
				customerScrollPane.setVisible(true);
				productScrollPane.setVisible(false);
				orderScrollPane.setVisible(false);
				// Clear the input fields after a successful addition
				customerNameField.setText("");
				customerEmailField.setText("");
				customerAgeField.setText("");
			}
		});
		image1.add(customerInputPanel);

		// Order Input Panel
		orderInputPanel = new JPanel();
		orderInputPanel.setLayout(null);
		orderInputPanel.setBounds(10, 60, 290, 210);
		orderInputPanel.setVisible(false);

		JLabel customerIdLabel = new JLabel("Customer ID:");
		customerIdLabel.setBounds(10, 10, 100, 20);
		orderInputPanel.add(customerIdLabel);

		JTextField customerIdField = new JTextField();
		customerIdField.setBounds(120, 10, 150, 20);
		orderInputPanel.add(customerIdField);

		JButton enterCustomerIdButton = new JButton("Enter Customer ID");
		enterCustomerIdButton.setBounds(10, 40, 260, 30);
		orderInputPanel.add(enterCustomerIdButton);

		JLabel clothIdLabel = new JLabel("Cloth ID:");
		clothIdLabel.setBounds(10, 80, 100, 20);
		orderInputPanel.add(clothIdLabel);
		clothIdLabel.setVisible(false);

		JTextField clothIdField = new JTextField();
		clothIdField.setBounds(120, 80, 150, 20);
		orderInputPanel.add(clothIdField);
		clothIdField.setVisible(false);

		JButton addClothButton = new JButton("ADD Cloth");
		addClothButton.setBounds(10, 140, 120, 30);
		orderInputPanel.add(addClothButton);
		addClothButton.setVisible(false);

		JButton enterOrderButton = new JButton("Enter");
		enterOrderButton.setBounds(10, 175, 120, 30);
		orderInputPanel.add(enterOrderButton);

		JButton clearOrderButton = new JButton("Clear");
		clearOrderButton.setBounds(140, 175, 120, 30);
		orderInputPanel.add(clearOrderButton);
		
		showAllButton.setFocusable(false);
		editButton.setFocusable(false);
		deleteButton.setFocusable(false);
		searchButton.setFocusable(false);
		addOrderButton.setFocusable(false);
		showCustomerButton.setFocusable(false);
		addProductButton.setFocusable(false);
		addCustomerButton.setFocusable(false);
		clearClothButton.setFocusable(false);
		showOrderButton.setFocusable(false);
		
		clothIdField.requestFocus();
		// key order
		customerIdField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
                    enterCustomerIdButton.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
		enterCustomerIdButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
                	// Retrieve the entered customer ID from the field
    				int customerId = Integer.parseInt(customerIdField.getText());
    				Customer cust;
    				try {
    					cust = store1.getCustomerById(customerId);
    					order = new Order(cust);
    				} catch (CustomerNotFoundException e1) {
    					e1.printStackTrace();
    				}

    				// Show the panel for adding Cloth
    				addClothButton.setVisible(true);			
    				clothIdLabel.setVisible(true);
    				clothIdField.setVisible(true);
    				clothIdField.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
		
		clothIdField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
    				addClothButton.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
		addClothButton.addKeyListener(new KeyListener() {
			int clothId;
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
                	clothId = Integer.parseInt(clothIdField.getText());
    				try {
    					order.addCloth(store1.getClothById(clothId));
    					JOptionPane.showMessageDialog(clothInputPanel, "Cloth added to order successfully!", "Success",
    							JOptionPane.INFORMATION_MESSAGE);
    					clothIdField.setText("");
    					clothIdField.requestFocus();
    				} catch (ProductNotFoundException e1) {
    					e1.printStackTrace();
    				}
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
		// key order end
		// Action listener for the "Enter Customer ID" button
		enterCustomerIdButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Retrieve the entered customer ID from the field
				int customerId = Integer.parseInt(customerIdField.getText());
				Customer cust;
				try {
					cust = store1.getCustomerById(customerId);
					order = store1.createOrder(cust);
				} catch (CustomerNotFoundException e1) {
					e1.printStackTrace();
				}

				// Show the panel for adding Cloth
				addClothButton.setVisible(true);
				clothIdLabel.setVisible(true);
				clothIdField.setVisible(true);
			}
		});

		// Action listener for the "ADD Cloth" button
		addClothButton.addActionListener(new ActionListener() {
			int clothId;

			@Override
			public void actionPerformed(ActionEvent e) {
				clothId = Integer.parseInt(clothIdField.getText());
				try {
					order.addCloth(store1.getClothById(clothId));
					JOptionPane.showMessageDialog(clothInputPanel, "Cloth added to order successfully!", "Success",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (ProductNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});

		// Action listener for the "Enter" button
		enterOrderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!customerIdField.getText().equals("")) {
					store1.addOrder(order);
					JOptionPane.showMessageDialog(orderInputPanel, "Order Placed successfully!", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					customerIdField.setText("");
					clothIdField.setText("");
					showOrderTable();
					orderScrollPane.setVisible(true);
					productScrollPane.setVisible(false);
					customerScrollPane.setVisible(false);
					orderInputPanel.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(orderInputPanel, "Input Customer ID", "Blank",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// Action listener for the "Clear" button
		clearOrderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customerIdField.setText("");
				clothIdField.setText("");
			}
		});
		image1.add(orderInputPanel);

// orderInputPanel end
		//product
		String[] prodColumnNames = { "ID", "Name", "Price", "Size", "Material / Brand", "In Stock" };
		productTableModel = new DefaultTableModel(prodColumnNames, 0);
		productTable = new JTable(productTableModel);

		productTable.getColumnModel().getColumn(0).setPreferredWidth(50); 
		productTable.getColumnModel().getColumn(1).setPreferredWidth(200); 
		productTable.getColumnModel().getColumn(2).setPreferredWidth(80); 
		productTable.getColumnModel().getColumn(3).setPreferredWidth(80); 
		productTable.getColumnModel().getColumn(4).setPreferredWidth(150); 
		productTable.getColumnModel().getColumn(5).setPreferredWidth(80); 
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(productTableModel);
        productTable.setRowSorter(sorter);
		productScrollPane = new JScrollPane(productTable);
		productScrollPane.setBounds(25, 380, 1070, 200);
		image1.add(productScrollPane);
		productScrollPane.setVisible(false);
		//customer
		String[] custColumnNames = { "ID", "Name", "Email", "Age"};
		customerTableModel = new DefaultTableModel(custColumnNames, 0);
		customerTable = new JTable(customerTableModel);

		customerTable.getColumnModel().getColumn(0).setPreferredWidth(50); 
		customerTable.getColumnModel().getColumn(1).setPreferredWidth(240); 
		customerTable.getColumnModel().getColumn(2).setPreferredWidth(270); 
		customerTable.getColumnModel().getColumn(3).setPreferredWidth(80); 
		TableRowSorter<DefaultTableModel> sorter2 = new TableRowSorter<>(customerTableModel);
        customerTable.setRowSorter(sorter2);
		customerScrollPane = new JScrollPane(customerTable);
		customerScrollPane.setBounds(25, 380, 1070, 200);
		image1.add(customerScrollPane);
		customerScrollPane.setVisible(false);
		//order
		String[] orderColumnNames = { "ID", "Customer Name", "Items Ordered", "Total Price"};
		orderTableModel = new DefaultTableModel(orderColumnNames, 0);
		orderTable = new JTable(orderTableModel);

		orderTable.getColumnModel().getColumn(0).setPreferredWidth(50); 
		orderTable.getColumnModel().getColumn(1).setPreferredWidth(220); 
		orderTable.getColumnModel().getColumn(2).setPreferredWidth(290); 
		orderTable.getColumnModel().getColumn(3).setPreferredWidth(80); 

		orderScrollPane = new JScrollPane(orderTable);
		orderScrollPane.setBounds(25, 380, 1070, 200);
		image1.add(orderScrollPane);
		orderScrollPane.setVisible(false);
		//table end
		// Add a search panel
		searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBounds(310, 60, 300, 300);
		searchPanel.setVisible(false);

		// Add a label and text field for searching
		JLabel searchLabel = new JLabel("Search by Name:");
		searchLabel.setBounds(10, 10, 120, 20);
		searchPanel.add(searchLabel);

		JTextField searchTextField = new JTextField();
		searchTextField.setBounds(140, 10, 150, 20);
		searchPanel.add(searchTextField);

		// Add a search button
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(10, 40, 100, 30);
		searchPanel.add(searchButton);

		// Add an action listener for the search button
		searchButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String searchName = searchTextField.getText();
		        
		        // Perform the product search
		        List<Cloth> searchResults = new ArrayList<>();
				try {
					searchResults = store1.searchClothesByName(searchName);
				} catch (ProductNotFoundException e1) {
					// do nothing, it'll show nothing. cuz nothing found
				}

		        // Display the search results in a table
		        productTableModel.setRowCount(0); // Clear existing rows
		        for (Cloth cloth : searchResults) {
		                productTableModel.addRow(new Object[]{cloth.getProductId(), cloth.getName(), cloth.getPrice(), cloth.getSize(), cloth.getMaterial(), cloth.isInStock()});
		        }

		        productScrollPane.setVisible(true);
		        customerScrollPane.setVisible(false);
		        orderScrollPane.setVisible(false);
		    }
		});

		// Add the search panel to the main panel
		image1.add(searchPanel);
		
		setSize(1120, 630);
		setLocation(250, 100);
		setVisible(true);
		setFocusable(false);
		
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == addCustomerButton) {
			clothInputPanel.setVisible(false);
			if (!customerInputPanel.isVisible())
				customerInputPanel.setVisible(true);
			else
				customerInputPanel.setVisible(false);
		} else if (ae.getSource() == addOrderButton) {
			if (!orderInputPanel.isVisible())
				orderInputPanel.setVisible(true);
			else
				orderInputPanel.setVisible(false);
		} else if (ae.getSource() == addProductButton) {
			customerInputPanel.setVisible(false);
			if (!clothInputPanel.isVisible())
				clothInputPanel.setVisible(true);
			else
				clothInputPanel.setVisible(false);
		} else if (ae.getSource() == searchButton) {
			if (!searchPanel.isVisible())searchPanel.setVisible(true);
			else searchPanel.setVisible(false);
		} else if (ae.getSource() == deleteButton) {
			// Handle deleting
		} else if (ae.getSource() == editButton) {
			// Handle editing
		} else if (ae.getSource() == showAllButton) {
			showProductTable();
			if (!productScrollPane.isVisible()) productScrollPane.setVisible(true);
			else productScrollPane.setVisible(false);
		} else if (ae.getSource() == showCustomerButton) {
			showCustomerTable();
			if (!customerScrollPane.isVisible()) customerScrollPane.setVisible(true);
			else customerScrollPane.setVisible(false);
		} else if (ae.getSource() == showOrderButton) {
			showOrderTable();
			if (!orderScrollPane.isVisible()) orderScrollPane.setVisible(true);
			else orderScrollPane.setVisible(false);
		}

	}

	// Method to populate and show the product table
	private void showProductTable() {
		productTableModel.setRowCount(0);
		// Populate the table with product data
		for (Cloth cloth : store1.getClothes()) {
			productTableModel.addRow(new Object[] { cloth.getProductId(), cloth.getName(), cloth.getPrice(), cloth.getSize(),
					cloth.getMaterial(), cloth.isInStock() });
		}

		customerScrollPane.setVisible(false);
		orderScrollPane.setVisible(false);
	}

	// Method to populate and show the customer table
	private void showCustomerTable() {
		customerTableModel.setRowCount(0);
		// Populate the table with product data
		for (Customer customer : store1.getCustomers()) {
			customerTableModel.addRow(new Object[] { customer.getCustomerId(), customer.getName(), customer.getEmail(), customer.getAge() });
		}
		
		productScrollPane.setVisible(false);
		orderScrollPane.setVisible(false);
	}
	
	// Method to display all order details
	private void showOrderTable() {
	    // Clear the existing rows in the order table
	    orderTableModel.setRowCount(0);

	    for (Order order : store1.getOrders()) {
	        String customerName = order.getCustomer().getName();

	        // Create a StringBuilder to build the list of clothes
	        StringBuilder itemsOrdered = new StringBuilder();

	        for (Cloth cloth : order.getClothes()) {
	            itemsOrdered.append(cloth.getName()).append(", ");
	        }

	        // Remove the trailing ", " from the list of items
	        if (itemsOrdered.length() > 0) {
	            itemsOrdered.setLength(itemsOrdered.length() - 2);
	        }
	        
	        orderTableModel.addRow(new Object[]{order.getOrderId(), customerName, itemsOrdered.toString(), order.calculateTotalAmount()});
	    }
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(orderTableModel);
	    sorter.setComparator(3, Comparator.comparingDouble(value -> {
	        if (value instanceof Double) {
	            return (Double) value;
	        } else if (value instanceof String) {
	            try {
	                return Double.parseDouble((String) value);
	            } catch (NumberFormatException e) {
	                return 0.0; 
	            }
	        }
	        return 0.0; 
	    }));

	    orderTable.setRowSorter(sorter);
	    productScrollPane.setVisible(false);
		customerScrollPane.setVisible(false);
	}

	public static void main(String[] args) {
	    try {
	        HomePage gui = new HomePage();
	        gui.setVisible(true);

	        // Register a shutdown hook to save data when the application is closed
	        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
	            store1.saveDataToFile("data.bin");
	        }));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
