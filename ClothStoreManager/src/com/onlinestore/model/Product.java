package com.onlinestore.model;

import java.io.Serializable;

// Interface for common product properties
interface ProductInterface {
	int getProductId();

	String getName();

	double getPrice();
}

// Interface for stock availability + void body
interface StockAvailability {
	boolean isInStock();

	void setInStock(boolean inStock);
}

public class Product implements ProductInterface, Serializable {
	private static final long serialVersionUID = 1L;
	private static int nextProductId = 801;
	private int productId;
	private String name;
	private double price;

	
	public static int getNextProductId() {
		return nextProductId;
	}

	public static void setNextProductId(int nextProductId) {
		Product.nextProductId = nextProductId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		this.productId = generateProductId();
	}

	private static int generateProductId() {
		return nextProductId++;
	}

	@Override
	public String toString() {
		return "Category : " + this.name + " Product ID : " + this.productId + " Price : " + this.price + " Taka. ";
	}
}