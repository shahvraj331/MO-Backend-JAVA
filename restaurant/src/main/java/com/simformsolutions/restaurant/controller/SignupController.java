package com.simformsolutions.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.simformsolutions.restaurant.model.Customer;
import com.simformsolutions.restaurant.repository.CustomerRepo;

@RestController
@RequestMapping("/home")

public class SignupController {

	@Autowired
	CustomerRepo customerRepo;
	
	@PostMapping("/signup")
	public ResponseEntity<Customer> saveStudent( @RequestParam("name") String name, @RequestParam("email") String email,@RequestParam("password") String password)
	{
		Customer c = new Customer(name,email,password);
		if(customerRepo.findByEmail(email) == null){
			return new ResponseEntity<Customer>(customerRepo.save(c),HttpStatus.CREATED);
		}
		else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
