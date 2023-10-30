package com.onlinestore;

import com.onlinestore.model.*;

import java.util.Scanner;
import java.util.List;

// ConsoleApp to implement our System in the lowest possible configuration
public class OnlineStoreConsoleApp {
	public static OnlineStoreManagementSystem store1;

	public OnlineStoreConsoleApp() {
		store1 = new OnlineStoreManagementSystem();
		store1 = OnlineStoreManagementSystem.loadDataFromFile("data.bin");
	}

	public static void main(String[] args) {
		try {
			if (store1 == null) {
				store1 = new OnlineStoreManagementSystem();
			}

			OnlineStoreConsoleApp app = new OnlineStoreConsoleApp();
			Scanner sc = new Scanner(System.in);
			int choice;

			do {
				System.out.println("Online Store Management System Menu");
				System.out.println("1. Show all Products");
				System.out.println("2. Show all Customers");
				System.out.println("3. Show all Orders");
				System.out.println("4. Add new Product (Shoe or Cloth)");
				System.out.println("5. Add new Customer");
				System.out.println("6. Add new Order");
				System.out.println("7. Search Product, Customer, or Order");
				System.out.println("8. Delete Product, Customer, or Order");
				System.out.println("9. Edit Product, Customer, or Order");
				System.out.println("0. Exit");
				System.out.print("Enter your choice: ");
				choice = sc.nextInt();
				sc.nextLine(); // Consume the newline character

				switch (choice) {
				case 1:
					app.showAllProducts();
					break;
				case 2:
					app.showAllCustomers();
					break;
				case 3:
					app.showAllOrders();
					break;
				case 4:
					app.addNewProduct(sc);
					break;
				case 5:
					app.addNewCustomer(sc);
					break;
				case 6:
					app.addNewOrder(sc);
					break;
				case 7:
					app.searchEntities(sc);
					break;
				case 8:
					app.deleteEntities(sc);
					break;
				case 9:
					app.editEntities(sc);
					break;
				case 0:
					System.out.println("Exiting the program.");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
				}
			} while (choice != 0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			store1.saveDataToFile("data.bin");
		}
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

	private void showAllCustomers() {
		System.out.println("All Customers:");
		store1.displayCustomers();
	}

	private void showAllOrders() {
		System.out.println("All Orders:");
		store1.displayOrders();
	}

	private void addNewProduct(Scanner sc) {
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

	private void addNewCustomer(Scanner sc) {
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

	private void addNewOrder(Scanner sc) {
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

	private void searchEntities(Scanner sc) {
		System.out.println("Select Entity Type to Search:");
		System.out.println("1. Product (Shoe or Cloth)");
		System.out.println("2. Customer");
		System.out.println("3. Order");
		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		sc.nextLine();

		if (choice == 1) {
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
		} else if (choice == 2) {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (choice == 3) {
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
	}

	private void deleteEntities(Scanner sc) {
		System.out.println("Select Entity Type to delete:");
		System.out.println("1. Product (Shoe or Cloth)");
		System.out.println("2. Customer");
		System.out.println("3. Order");
		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		sc.nextLine();

		if (choice == 1) {
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
		} else if (choice == 2) {
			System.out.print("Enter the customerID to delete: ");
			int customerID = sc.nextInt();
			sc.nextLine();
			try {
				store1.deleteCustomer(customerID);
			} catch (CustomerNotFoundException e) {
				e.printStackTrace();
			}
		} else if (choice == 3) {
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

	private void editEntities(Scanner sc) {
		System.out.println("Select Entity Type to Edit: ");
		System.out.println("1. Product (Shoe or Cloth)");
		System.out.println("2. Customer");

		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		sc.nextLine();

		if (choice == 1) {
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
		} else if (choice == 2) {
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
	}
}
