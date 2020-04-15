package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/persons/all")
	public List<Person> all() {
		return personService.findAll();
	}
	
	@GetMapping("/persons/get-name")
	public String findName(@RequestParam(name="personId") String id) {
		
		for(int i = 0; i < personService.findAll().size(); i++) {
			if(personService.findAll().get(i).getId().equals(id)) return personService.findAll().get(i).getName();
		}

	    return null;
	}
	
	@GetMapping("/persons/get-address")
	public String findAddress(@RequestParam(name="personId") String id) {
		
		for(int i = 0; i < personService.findAll().size(); i++) {
			if(personService.findAll().get(i).getId().equals(id)) return personService.findAll().get(i).getAddress();
		}

	    return null;
	}
	
}