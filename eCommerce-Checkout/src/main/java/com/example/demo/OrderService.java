package com.example.demo;

import java.util.List;

public interface OrderService {
	
	public abstract List<Order> findAll();
	public abstract String checkout(String productId, String personId);

}
