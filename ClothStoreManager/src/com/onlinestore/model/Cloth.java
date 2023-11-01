package com.onlinestore.model;

import java.io.Serializable;

public class Cloth extends Product implements StockAvailability, Serializable {
	private static final long serialVersionUID = 1L;
	private String size;
	private String material;
	private boolean inStock;

	public Cloth(String name, double price, String size, String material, boolean inStock) {

		super(name, price);
		this.size = size;
		this.material = material;
		this.inStock = inStock;
	}
	
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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
		return super.toString() + "Size : " + this.size + " Material : " + this.material + " In Stock : "
				+ this.inStock;
	}
}
