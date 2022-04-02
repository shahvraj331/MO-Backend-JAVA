package com.simformsolutions.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simformsolutions.restaurant.model.Customer;
import com.simformsolutions.restaurant.repository.CustomerRepo;

@RestController
@RequestMapping("/home")

public class SignupController {

	@Autowired
	CustomerRepo customerRepo;
	
	@PostMapping("/signup")
	public ResponseEntity<Customer> saveStudent( @RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(customerRepo.save(customer),HttpStatus.CREATED);
	}
}
