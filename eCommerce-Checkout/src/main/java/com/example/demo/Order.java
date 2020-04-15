package com.example.demo;

import org.springframework.data.annotation.Id;

public class Order {
	
	@Id private String id;
	
	private String name;
	private String address;
	private String productId;
	private double priceWithTax;
	

	
	public String getId() {
		return id;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getPriceWithTax() {
		return priceWithTax;
	}

	public void setPriceWithTax(double priceWithTax) {
		this.priceWithTax = priceWithTax;
	}

	public Order(String name, String address, String productId, double priceWithTax) {
		this.name = name;
		this.address = address;
		this.productId = productId;
		this.priceWithTax = priceWithTax;
	}
	
}