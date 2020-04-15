package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products/all")
	public List<Product> findAll() {
		return productService.findAll();
	}
	
	
	@GetMapping("/products/get-price")
	public double getPrice(@RequestParam(name="productId") String id) {
		
		
		for(int i = 0; i < productService.findAll().size(); i++) {
			if(productService.findAll().get(i).getId().equals(id)) return productService.findAll().get(i).getPrice();
		}
	
	    return -1;
	}
	
	@GetMapping("/products/get-sku")
	public int getSku (@RequestParam(name="productId") String id) {
		
		for(int i = 0; i < productService.findAll().size(); i++) {
			if(productService.findAll().get(i).getId().equals(id)) return productService.findAll().get(i).getSku();
		}
	
	    return -1;
		
	}
	
	
}