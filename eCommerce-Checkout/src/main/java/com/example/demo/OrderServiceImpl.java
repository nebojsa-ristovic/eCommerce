package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public String checkout(String productId, String personId) {
		return null;
	}


}