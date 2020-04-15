package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TaxController {

	@GetMapping("/price-with-tax")
	public double priceCalculation (@RequestParam(name="productId") String id) {
		
		double taxRate = 0.2;
		
		RestTemplate tmp = new RestTemplate();
		int sku = tmp.getForObject("http://localhost:8080/products/get-sku?productId=" + id, Integer.class);
		if(sku < 1) return -1;
		
		double price = tmp.getForObject("http://localhost:8080/products/get-price?productId=" + id, Double.class);
		
		return price*(taxRate+1);
        
	}
	
}