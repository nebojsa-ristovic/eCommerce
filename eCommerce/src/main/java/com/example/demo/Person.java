package com.example.demo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {

  @Id private String id;

  private String name;
  private String address;

  public String getId() {
	    return id;
	  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
  
  public Person(String name, String address) {
	  this.name = name;
	  this.address = address;
  }
}
