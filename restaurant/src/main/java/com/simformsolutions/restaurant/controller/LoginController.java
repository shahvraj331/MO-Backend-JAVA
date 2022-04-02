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
public class LoginController {
	
	@Autowired
	private CustomerRepo customerRepo;

	@PostMapping("/login")
	public ResponseEntity<String> LoginPost (@RequestBody Customer customer)
	{
		
		if(customerRepo.findByEmail(customer.getEmail()) != null && customerRepo.findByPassword(customer.getPassword()) != null)
		{
			return new ResponseEntity<String>("Login Successfull..!!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Wrong login credentials.", HttpStatus.UNAUTHORIZED);	
		
	}
	
}
