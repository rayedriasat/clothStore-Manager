package com.onlinestore.model;

import java.io.Serializable;

public class Shoe extends Product implements StockAvailability, Serializable {
	private static final long serialVersionUID = 1L;
	private String size;
	private String brand;
	private boolean inStock;

	public Shoe(String name, double price, String size, String brand, boolean inStock) {
		super(name, price);
		this.size = size;
		this.brand = brand;
		this.inStock = inStock;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public boolean isInStock() {
		return inStock;
	}

	@Override
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	@Override
	public String toString() {
		return super.toString() + "Size : " + this.size + " Brand : " + this.brand + " In Stock : " + this.inStock;
	}
}
