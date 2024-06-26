package com.onlinestore.model;

import java.io.Serializable;
abstract class Wearable extends Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private String size;
	private String material;
	
	public Wearable(String name, double price, String size, String material) {
		super(name, price);
		this.size = size;
		this.material = material;
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
}
public class Cloth extends Wearable implements StockAvailability, Serializable {
	private static final long serialVersionUID = 1L;

	private boolean inStock;

	public Cloth(String name, double price, String size, String material, boolean inStock) {

		super(name, price, size, material);

		this.inStock = inStock;
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
		return super.toString() + "Size : " + this.getSize() + " Material : " + this.getMaterial() + " In Stock : "
				+ this.inStock;
	}
}
