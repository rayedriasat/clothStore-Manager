package com.onlinestore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
    private static int nextOrderId = 1;
    private int orderId;
    private Customer customer;
    private List<Cloth> clothes;
    private List<Shoe> shoes;

    public Order(Customer customer) {
        this.orderId = nextOrderId++;
        this.customer = customer;
        this.clothes = new ArrayList<>();
        this.shoes = new ArrayList<>();
    }

    
    public static int getNextOrderId() {
		return nextOrderId;
	}


	public static void setNextOrderId(int nextOrderId) {
		Order.nextOrderId = nextOrderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public void setClothes(List<Cloth> clothes) {
		this.clothes = clothes;
	}


	public void setShoes(List<Shoe> shoes) {
		this.shoes = shoes;
	}


	public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Cloth> getClothes() {
        return clothes;
    }

    public List<Shoe> getShoes() {
        return shoes;
    }

    public void addCloth(Cloth cloth) {
        clothes.add(cloth);
    }

    public void addShoe(Shoe shoe) {
        shoes.add(shoe);
    }

    public double calculateTotalAmount() {
        double total = 0.0;
        for (Cloth cloth : clothes) {
            total += cloth.getPrice();
        }
        for (Shoe shoe : shoes) {
            total += shoe.getPrice();
        }
        return total;
    }
}
