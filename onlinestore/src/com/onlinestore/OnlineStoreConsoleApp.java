package com.onlinestore;

import com.onlinestore.model.*;

import java.util.Scanner;
import java.util.List;

//ConsoleApp to implement our System in the lowest possible configuration
public class OnlineStoreConsoleApp {
    private OnlineStoreManagementSystem store1;
    private Scanner sc;

    public OnlineStoreConsoleApp() {
        store1 = new OnlineStoreManagementSystem();
        store1 = OnlineStoreManagementSystem.loadDataFromFile("data.bin");
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        OnlineStoreConsoleApp app = new OnlineStoreConsoleApp();
        app.runMainMenu();
    }

    private void runMainMenu() {
        int mainMenuChoice;
        do {
            System.out.println("Online Store Management System Menu");
            System.out.println("1. Products");
            System.out.println("2. Customers");
            System.out.println("3. Orders");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            mainMenuChoice = sc.nextInt();
            sc.nextLine();

            switch (mainMenuChoice) {
                case 1:
                    runProductsMenu();
                    break;
                case 2:
                    runCustomersMenu();
                    break;
                case 3:
                    runOrdersMenu();
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (mainMenuChoice != 0);
    }

    private void runProductsMenu() {
        int productsMenuChoice;
        do {
            System.out.println("\nProducts Menu");
            System.out.println("1. Show all Products");
            System.out.println("2. Add new Product (Shoe or Cloth)");
            System.out.println("3. Search Product");
            System.out.println("4. Edit Product");
            System.out.println("5. Delete Product");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            productsMenuChoice = sc.nextInt();
            sc.nextLine();

            switch (productsMenuChoice) {
                case 1:
                    showAllProducts();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 4:
                    editProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (productsMenuChoice != 0);
    }

    private void showAllProducts() {
		System.out.println("All Products (Clothes and Shoes):");
		List<Cloth> clothes = store1.getClothes();
		List<Shoe> shoes = store1.getShoes();

		System.out.println("Clothes:");
		for (Cloth cloth : clothes) {
			System.out.println(cloth);
		}

		System.out.println("Shoes:");
		for (Shoe shoe : shoes) {
			System.out.println(shoe);
		}
	}

    private void addNewProduct() {
    	System.out.println("Select Product Type:");
		System.out.println("1. Cloth");
		System.out.println("2. Shoe");
		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Price: ");
		double price = sc.nextDouble();
		sc.nextLine();

		if (choice == 1) {
			System.out.print("Enter Size: ");
			String size = sc.nextLine();
			System.out.print("Enter Material: ");
			String material = sc.nextLine();
			System.out.print("Is it in stock? (true/false): ");
			boolean inStock = sc.nextBoolean();
			sc.nextLine();

			Cloth cloth = new Cloth(name, price, size, material, inStock);
			store1.addCloth(cloth);
			System.out.println("Cloth added successfully.");
		} else if (choice == 2) {
			System.out.print("Enter Size: ");
			String size = sc.nextLine();
			System.out.print("Enter Brand: ");
			String brand = sc.nextLine();
			System.out.print("Is it in stock? (true/false): ");
			boolean inStock = sc.nextBoolean();
			sc.nextLine();

			Shoe shoe = new Shoe(name, price, size, brand, inStock);
			store1.addShoe(shoe);
			System.out.println("Shoe added successfully.");
		}
	}


    private void searchProduct() {
    	System.out.print("Enter the product name to search: ");
		String name = sc.nextLine();
		try {
			List<Cloth> matchingClothes;
			matchingClothes = store1.searchClothesByName(name);
			List<Shoe> matchingShoes;
			matchingShoes = store1.searchShoesByName(name);

			System.out.println("Matching Clothes:");
			for (Cloth cloth : matchingClothes) {
				System.out.println(cloth);
			}

			System.out.println("Matching Shoes:");
			for (Shoe shoe : matchingShoes) {
				System.out.println(shoe);
			}
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
    }

    private void editProduct() {
    	System.out.print("Enter the product type: ");
		System.out.println("1. Cloth");
		System.out.println("2. Shoe");

		int type = sc.nextInt();
		sc.nextLine();
		if (type == 1) {
			System.out.println("Enter clothID: ");
			int clothID = sc.nextInt();
			sc.nextLine();
			String name;
			double price;
			String size;
			String material;
			String toggleStock;
			try {
				Cloth cloth = store1.getClothById(clothID);
				System.out.println(cloth);
				System.out.println("Enter fields to edit: (enter 0 to keep that field unchanged)");
				System.out.print("newName: ");
				name = sc.nextLine();
				System.out.print("newPrice: ");
				price = sc.nextDouble();
				sc.nextLine();
				System.out.print("newSize: ");
				size = sc.nextLine();
				System.out.print("newMaterial: ");
				material = sc.nextLine();
				System.out.print("Toggle inStock stat? (y/n): ");
				toggleStock = sc.next();
				if (toggleStock.equalsIgnoreCase("y")) {
					if (cloth.isInStock())
						cloth.setInStock(false);
					else
						cloth.setInStock(true);
				}
				store1.editCloth(clothID, name, price, size, material);
				System.out.println("Edited successfully :");
				System.out.println(store1.getClothById(clothID));
			} catch (ProductNotFoundException e) {
				e.printStackTrace();
			}
		} else if (type == 2) {
			System.out.println("Enter shoeID: ");
			int shoeID = sc.nextInt();
			sc.nextLine();
			String name;
			double price;
			String size;
			String brand;
			String toggleStock;
			try {
				Shoe shoe = store1.getShoeById(shoeID);
				System.out.println(shoe);
				System.out.println("Enter fields to edit: (enter 0 to keep that field unchanged)");
				System.out.print("newName: ");
				name = sc.nextLine();
				System.out.print("newPrice: ");
				price = sc.nextDouble();
				sc.nextLine();
				System.out.print("newSize: ");
				size = sc.nextLine();
				System.out.print("newBrand: ");
				brand = sc.nextLine();
				System.out.print("Toggle inStock stat? (y/n): ");
				toggleStock = sc.next();
				if (toggleStock.equalsIgnoreCase("y")) {
					if (shoe.isInStock())
						shoe.setInStock(false);
					else
						shoe.setInStock(true);
				}
				store1.editShoe(shoeID, name, price, size, brand);
			} catch (ProductNotFoundException e) {
				e.printStackTrace();
			}
		}
    }

    private void deleteProduct() {
    	System.out.println("1. Cloth");
		System.out.println("2. Shoe");
		System.out.print("Enter the product type: ");
		int type = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter productID to delete: ");
		try {
			if (type == 1) {
				int productID = sc.nextInt();
				sc.nextLine();
				store1.deleteCloth(productID);
			} else if (type == 2) {
				int productID = sc.nextInt();
				sc.nextLine();
				store1.deleteShoe(productID);
			}
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
    }

    private void runCustomersMenu() {
        int customersMenuChoice;
        do {
            System.out.println("\nCustomers Menu");
            System.out.println("1. Show all Customers");
            System.out.println("2. Add new Customer");
            System.out.println("3. Search Customer");
            System.out.println("4. Edit Customer");
            System.out.println("5. Delete Customer");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            customersMenuChoice = sc.nextInt();
            sc.nextLine();

            switch (customersMenuChoice) {
                case 1:
                    showAllCustomers();
                    break;
                case 2:
                    addNewCustomer();
                    break;
                case 3:
                    searchCustomer();
                    break;
                case 4:
                    editCustomer();
                    break;
                case 5:
                    deleteCustomer();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (customersMenuChoice != 0);
    }

    private void showAllCustomers() {
		System.out.println("All Customers:");
		store1.displayCustomers();
	}

    private void addNewCustomer() {
    	System.out.print("Enter Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Email: ");
		String email = sc.nextLine();
		System.out.print("Enter Age: ");
		int age = sc.nextInt();
		sc.nextLine();

		Customer customer = new Customer(name, email, age);
		store1.addCustomer(customer);
		System.out.println("Customer added successfully.");
    }

    private void searchCustomer() {
    	System.out.print("Enter the customer name to search: ");
		String name = sc.nextLine();
		try {
			List<Customer> matchingCustomers;
			matchingCustomers = store1.searchCustomersByName(name);

			System.out.println("Matching Customers:");
			for (Customer customer : matchingCustomers) {
				System.out.println(customer);
			}
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
    }

    private void editCustomer() {
    	System.out.println("Enter customerID: ");
		int customerID = sc.nextInt();
		sc.nextLine();
		String name;
		String email;
		int age;
		try {
			Customer cust = store1.getCustomerById(customerID);
			System.out.println(cust);
			System.out.println("Enter fields to edit: (enter 0 to keep that field unchanged)");
			System.out.print("newName: ");
			name = sc.nextLine();
			System.out.print("newEmail: ");
			email = sc.nextLine();
			System.out.print("newAge: ");
			age = sc.nextInt();
			sc.nextLine();

			store1.editCustomer(customerID, name, email, age);
			System.out.println("Edited successfully :");
			System.out.println(cust);
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
    }

    private void deleteCustomer() {
    	System.out.print("Enter the customerID to delete: ");
		int customerID = sc.nextInt();
		sc.nextLine();
		try {
			store1.deleteCustomer(customerID);
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
    }


    private void runOrdersMenu() {
        int ordersMenuChoice;
        do {
            System.out.println("\nOrders Menu");
            System.out.println("1. Show all Orders");
            System.out.println("2. Add new Order");
            System.out.println("3. Search Order");
            System.out.println("4. Delete Order");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            ordersMenuChoice = sc.nextInt();
            sc.nextLine();

            switch (ordersMenuChoice) {
                case 1:
                    showAllOrders();
                    break;
                case 2:
                    addNewOrder();
                    break;
                case 3:
                    searchOrder();
                    break;
                case 4:
                    deleteOrder();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (ordersMenuChoice != 0);
    }

    private void showAllOrders() {
		System.out.println("All Orders:");
		store1.displayOrders();
	}

    private void addNewOrder() {
    	System.out.print("Enter Customer ID for the order: ");
		int customerId = sc.nextInt();
		sc.nextLine();

		try {
			Customer customer = store1.getCustomerById(customerId);
			store1.createOrder(customer);
			System.out.println("Order created successfully.");
		} catch (CustomerNotFoundException e) {
			System.out.println("Customer not found. Please add the customer first.");
		}
    }

    private void searchOrder() {
    	System.out.print("Enter the OrderID to search: ");
		int OrderID = sc.nextInt();
		sc.nextLine();
		try {
			Order result = store1.getOrderById(OrderID);
			System.out.println(result);
		} catch (OrderNotFoundException e) {
			e.printStackTrace();
		}
    }

    private void deleteOrder() {
    	System.out.print("Enter the OrderID to delete: ");
		int OrderID = sc.nextInt();
		sc.nextLine();
		try {
			store1.deleteOrder(OrderID);
		} catch (OrderNotFoundException e) {
			e.printStackTrace();
		}
    }

}
