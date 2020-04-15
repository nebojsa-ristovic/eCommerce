package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	
	@Id private String id;
	
	private String name;
	private double price;
	private int sku;
	
	
	public String getId() {
		return id;
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
	public int getSku() {
		return sku;
	}
	public void setSku(int sku) {
		this.sku = sku;
	}
	
	public Product(String name, double price, int sku) {
		this.name = name;
		this.price = price;
		this.sku = sku;
	}
	
	public Product(String name, double price, int sku, String id) {
		this.name = name;
		this.price = price;
		this.sku = sku;
		this.id = id;
	}
	
	
}