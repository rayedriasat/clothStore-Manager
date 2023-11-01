package com.onlinestore.exeptions;

//Custom Exceptions for our System
@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception {
	public ProductNotFoundException(String message) {
		super(message);
	}
}