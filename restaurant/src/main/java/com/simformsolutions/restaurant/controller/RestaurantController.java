package com.simformsolutions.restaurant.controller;

import java.util.List;

import com.simformsolutions.restaurant.model.DiningTable;
import com.simformsolutions.restaurant.repository.TableRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simformsolutions.restaurant.model.Customer;
import com.simformsolutions.restaurant.model.Restaurant;
import com.simformsolutions.restaurant.repository.RestaurantRepo;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantRepo restaurantRepo;
	@Autowired
	private TableRepo tableRepo;
	
	//get list of Restaurants only
	@RequestMapping(value = "/allRestaurant" ,method = RequestMethod.GET)
	public  ResponseEntity<List<Restaurant>> allRestaurant(){
		
		return new ResponseEntity<List<Restaurant>>(restaurantRepo.findAll() , HttpStatus.OK);
		 
	}

	@RequestMapping(value = "/getTable/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<Restaurant> getTableDetails(@PathVariable("id") long id)
	{
		return new ResponseEntity<Restaurant>(restaurantRepo.findById(id).orElseThrow(),  HttpStatus.OK);
	}

	@RequestMapping(value = "/updateTable/{id}", method = RequestMethod.PUT)
	public ResponseEntity<DiningTable> updateDiningTable(@PathVariable("id") long id, @RequestBody DiningTable diningTable){
		DiningTable existingDiningTable = tableRepo.findById(id).orElse(null);
		BeanUtils.copyProperties(diningTable, existingDiningTable, "tableId");
		return new ResponseEntity<DiningTable>(tableRepo.saveAndFlush(diningTable), HttpStatus.OK);
	}
}
