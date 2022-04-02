package com.simformsolutions.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simformsolutions.restaurant.model.Restaurant;
import com.simformsolutions.restaurant.repository.RestaurantRepo;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantRepo restaurantRepo; 
	
	//get list of Restaurants only
	@RequestMapping(value = "/allRestaurant" ,method = RequestMethod.GET)
	public  ResponseEntity<List<Restaurant>> allRestaurant(){
		
		return new ResponseEntity<List<Restaurant>>(restaurantRepo.findAll() , HttpStatus.OK);
		 
	}

	
}
