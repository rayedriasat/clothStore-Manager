package com.onlinestore.model;

import java.io.Serializable;

abstract class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void displayDetails();
}

public class Customer extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	private static int nextCustomerId = 101;
	private int customerId;
	private String email;
	private int age;

	
	public static int getNextCustomerId() {
		return nextCustomerId;
	}

	public static void setNextCustomerId(int nextCustomerId) {
		Customer.nextCustomerId = nextCustomerId;
	}

	public Customer(String name, String email, int age) {
		super(name);
		this.email = email;
		this.age = age;
		this.customerId = generateCustomerId();
	}

	private static int generateCustomerId() {
		return nextCustomerId++;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void displayDetails() {
		System.out.println("Customer id: " + customerId + " Name: " + getName() + " Email: " + email + " Age: " + age);
	}
	
	@Override
	public String toString() {
		return "Customer id: " + customerId + " Name: " + getName() + " Email: " + email + " Age: " + age;
	}
}
