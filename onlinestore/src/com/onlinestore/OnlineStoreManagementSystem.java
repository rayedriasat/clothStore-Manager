package com.onlinestore;

import com.onlinestore.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// All the important functioning methods are in this java file

// Custom Exceptions for our System
@SuppressWarnings("serial")
class ProductNotFoundException extends Exception {
	public ProductNotFoundException(String message) {
		super(message);
	}
}

@SuppressWarnings("serial")
class CustomerNotFoundException extends Exception {
	public CustomerNotFoundException(String message) {
		super(message);
	}
}

@SuppressWarnings("serial")
class OrderNotFoundException extends Exception {
	public OrderNotFoundException(String message) {
		super(message);
	}
}

public class OnlineStoreManagementSystem implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Customer> customers;
	private List<Cloth> clothes;
	private List<Shoe> shoes;
	private List<Order> orders;

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Cloth> getClothes() {
		return clothes;
	}

	public void setClothes(List<Cloth> clothes) {
		this.clothes = clothes;
	}

	public List<Shoe> getShoes() {
		return shoes;
	}

	public void setShoes(List<Shoe> shoes) {
		this.shoes = shoes;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public OnlineStoreManagementSystem() {
		customers = new ArrayList<>();
		clothes = new ArrayList<>();
		shoes = new ArrayList<>();
		orders = new ArrayList<>();
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public void addCloth(Cloth cloth) {
		clothes.add(cloth);
	}

	public void addShoe(Shoe shoe) {
		shoes.add(shoe);
	}

	public void createOrder(Customer customer) {
		Order order = new Order(customer);
		orders.add(order);
	}

	public void addClothToOrder(int orderId, Cloth cloth) throws OrderNotFoundException {
		Order order = getOrderById(orderId);

		order.addCloth(cloth);

	}

	public void addShoeToOrder(int orderId, Shoe shoe) throws OrderNotFoundException {
		Order order = getOrderById(orderId);

		order.addShoe(shoe);

	}

	public void displayCustomers() {
		for (Customer customer : customers) {
			customer.displayDetails();
		}
	}

	public void displayClothes() {
		for (Cloth cloth : clothes) {
			System.out.println(cloth.toString());
		}
	}

	public void displayShoes() {
		for (Shoe shoe : shoes) {
			System.out.println(shoe.toString());
		}
	}

	public void displayOrders() {
		for (Order order : orders) {
			System.out.println("Order ID: " + order.getOrderId());
			System.out.println("Customer: " + order.getCustomer().getName());
			System.out.println("Clothes:");
			for (Cloth cloth : order.getClothes()) {
				System.out.println(cloth.toString());
			}
			System.out.println("Shoes:");
			for (Shoe shoe : order.getShoes()) {
				System.out.println(shoe.toString());
			}
			System.out.println("Total Amount: " + order.calculateTotalAmount());
			System.out.println("--------------------");
		}
	}

	public void deleteCustomer(int customerId) throws CustomerNotFoundException {
		Customer customer = getCustomerById(customerId);

		customers.remove(customer);

	}

	public void deleteCloth(int clothId) throws ProductNotFoundException {
		Cloth cloth = getClothById(clothId);

		clothes.remove(cloth);

	}

	public void deleteShoe(int shoeId) throws ProductNotFoundException {
		Shoe shoe = getShoeById(shoeId);

		shoes.remove(shoe);

	}

	public void deleteOrder(int orderId) throws OrderNotFoundException {
		Order order = getOrderById(orderId);

		orders.remove(order);

	}

	public List<Customer> searchCustomersByName(String name) throws CustomerNotFoundException {
		List<Customer> result = new ArrayList<>();
		for (Customer customer : customers) {
			if (customer.getName().equalsIgnoreCase(name)) {
				result.add(customer);
			}
		}
		if (result.size() == 0)
			throw new CustomerNotFoundException(name + " not Found");

		return result;
	}

	public List<Cloth> searchClothesByName(String name) throws ProductNotFoundException {
		List<Cloth> result = new ArrayList<>();
		for (Cloth cloth : clothes) {
			if (cloth.getName().equalsIgnoreCase(name)) {
				result.add(cloth);
			}
		}
		if (result.size() == 0)
			throw new ProductNotFoundException(name + " not Found");

		return result;
	}

	public List<Shoe> searchShoesByName(String name) throws ProductNotFoundException {
		List<Shoe> result = new ArrayList<>();
		for (Shoe shoe : shoes) {
			if (shoe.getName().equalsIgnoreCase(name)) {
				result.add(shoe);
			}
		}
		if (result.size() == 0)
			throw new ProductNotFoundException(name + " not Found");

		return result;
	}

	public void editCustomer(int customerId, String newName, String newEmail, int newAge)
			throws CustomerNotFoundException {
		Customer customer = getCustomerById(customerId);

		if (!newName.equals("0"))
			customer.setName(newName);
		if (!newEmail.equals("0"))
			customer.setEmail(newEmail);
		if (newAge != 0)
			customer.setAge(newAge);

	}

	public void editCloth(int clothId, String newName, double newPrice, String newSize, String newMaterial)
			throws ProductNotFoundException {
		Cloth cloth = getClothById(clothId);

		if (!newName.equals("0"))
			cloth.setName(newName);
		if (newPrice != 0)
			cloth.setPrice(newPrice);
		if (!newSize.equals("0"))
			cloth.setSize(newSize);
		if (!newMaterial.equals("0"))
			cloth.setMaterial(newMaterial);

	}

	public void editShoe(int shoeId, String newName, double newPrice, String newSize, String newBrand)
			throws ProductNotFoundException {
		Shoe shoe = getShoeById(shoeId);

		if (!newName.equals("0"))
			shoe.setName(newName);
		if (newPrice != 0)
			shoe.setPrice(newPrice);
		if (!newSize.equals("0"))
			shoe.setSize(newSize);
		if (!newBrand.equals("0"))
			shoe.setBrand(newBrand);

	}

	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
		for (Customer customer : customers) {
			if (customer.getCustomerId() == customerId) {
				return customer;
			}
		}
		throw new CustomerNotFoundException(customerId + "CustomerId not Found");
	}

	public Cloth getClothById(int clothId) throws ProductNotFoundException {
		for (Cloth cloth : clothes) {
			if (cloth.getProductId() == clothId) {
				return cloth;
			}
		}
		throw new ProductNotFoundException(clothId + " not Found");
	}

	public Shoe getShoeById(int shoeId) throws ProductNotFoundException {
		for (Shoe shoe : shoes) {
			if (shoe.getProductId() == shoeId) {
				return shoe;
			}
		}
		throw new ProductNotFoundException(shoeId + " not Found");
	}

	public Order getOrderById(int orderId) throws OrderNotFoundException {
		for (Order order : orders) {
			if (order.getOrderId() == orderId) {
				return order;
			}
		}
		throw new OrderNotFoundException(orderId + "OrderId not found");
	}

	public void saveDataToFile(String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(this);
			objectOut.writeInt(Product.getNextProductId());
			objectOut.writeInt(Customer.getNextCustomerId());
			objectOut.writeInt(Order.getNextOrderId());
			
			objectOut.close();
			fileOut.close();
			System.out.println("Data saved successfully.");
		} catch (IOException e) {
			System.out.println("Error saving data to file: " + e.getMessage());
		}
	}

	public static OnlineStoreManagementSystem loadDataFromFile(String fileName) {
		OnlineStoreManagementSystem system = null;
		try {
			File file = new File(fileName);

			if (file.exists()) {
				FileInputStream fileIn = new FileInputStream(file);
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);
				system = (OnlineStoreManagementSystem) objectIn.readObject();
				Product.setNextProductId(objectIn.readInt());
				Customer.setNextCustomerId(objectIn.readInt());
				Order.setNextOrderId(objectIn.readInt());
				
				objectIn.close();
				fileIn.close();
				System.out.println("Data loaded successfully.");
			} else {
				system = new OnlineStoreManagementSystem(); // Create an empty system
				System.out.println("New system !!!");
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error loading data from file: " + e.getMessage());
		}

		if (system == null) {
			system = new OnlineStoreManagementSystem(); // Create a new empty system if loading failed
			System.out.println("null, so New system !!!");
		}

		return system;
	}

}
