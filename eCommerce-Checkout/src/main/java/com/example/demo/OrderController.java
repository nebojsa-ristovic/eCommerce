package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping("/orders/all")
	public List<Order> findAll() {
		return orderService.findAll();
	}
	
	@GetMapping("/checkout")
	public String checkout(@RequestParam(name="productId") String productId,@RequestParam(name="personId") String personId) {
		
		RestTemplate tmp = new RestTemplate();
		
		//Poziv prvog mikroservisa i dobijanje imena i adrese
		String name = tmp.getForObject("http://localhost:8080/persons/get-name?personId=" + personId, String.class);
		String address = tmp.getForObject("http://localhost:8080/persons/get-address?personId=" + personId, String.class);
		
		//Poziv drugog mikroservisa i dobijanje cene sa ukljucenom taksom
		double priceWithTax = tmp.getForObject("http://localhost:8180/price-with-tax?productId=" + productId, Double.class);
		
		//kreiranje narudzbine u bazi
		orderRepository.save(new Order(name, address, productId, priceWithTax));
		
				
		return "Vasa narudzbina je poslata. ";
		
	}
	
	
}