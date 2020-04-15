package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;
	
	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
}