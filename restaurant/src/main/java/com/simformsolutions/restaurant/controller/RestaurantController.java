package com.simformsolutions.restaurant.controller;

import java.util.List;

import com.simformsolutions.restaurant.model.DiningTable;
import com.simformsolutions.restaurant.model.Feedback;
import com.simformsolutions.restaurant.model.Menu;
import com.simformsolutions.restaurant.model.Orders;
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
import com.simformsolutions.restaurant.repository.CustomerRepo;
import com.simformsolutions.restaurant.repository.FeedbackRepo;
import com.simformsolutions.restaurant.repository.MenuRepo;
import com.simformsolutions.restaurant.repository.OrdersRepo;
import com.simformsolutions.restaurant.repository.RestaurantRepo;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantRepo restaurantRepo; 
	@Autowired
	private TableRepo tableRepo; 
	@Autowired
	private MenuRepo menuRepo; 
	@Autowired
	private OrdersRepo ordersRepo;	
	@Autowired
	private FeedbackRepo feedbackRepo;	
	@Autowired
	private CustomerRepo customerRepo;
	
	//get list of Restaurants only
	@RequestMapping(value = "/allRestaurant" ,method = RequestMethod.GET)
	public  ResponseEntity<List<Restaurant>> allRestaurant(){
		
		return new ResponseEntity<List<Restaurant>>(restaurantRepo.findAll() , HttpStatus.OK);
		 
	}

	@RequestMapping(value = "/getTable/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<Restaurant> getTableDetails(@PathVariable("id") long id)
	{
		return new ResponseEntity<Restaurant>(restaurantRepo.findById(id).orElse(null),  HttpStatus.OK);
	}

	@RequestMapping(value = "/updateTable/{id}", method = RequestMethod.PUT)
	public ResponseEntity<DiningTable> updateDiningTable(@PathVariable("id") long id, @RequestBody DiningTable diningTable){
		DiningTable existingDiningTable = tableRepo.findById(id).orElse(null);
		BeanUtils.copyProperties(diningTable, existingDiningTable, "tableId");
		return new ResponseEntity<DiningTable>(tableRepo.saveAndFlush(diningTable), HttpStatus.OK);
	}
	
	
	
	
	
	
	@RequestMapping(value = "/settabledetails" ,method = RequestMethod.POST)
	public ResponseEntity<DiningTable> postTableDetails(@RequestBody DiningTable diningTable)
	{
		//return new ResponseEntity<Restaurant>(restaurantRepo.findTablesById(restaurant.getRestaurantId()),HttpStatus.OK);
		return new ResponseEntity<DiningTable>(tableRepo.save(diningTable),  HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/addmenu" ,method = RequestMethod.POST)
	public ResponseEntity<Menu> menuPost(@RequestBody Menu menu)
	{
		//return new ResponseEntity<Restaurant>(restaurantRepo.findTablesById(restaurant.getRestaurantId()),HttpStatus.OK);
		return new ResponseEntity<Menu>(menuRepo.save(menu),  HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/getmenu" ,method = RequestMethod.GET)
	public  ResponseEntity<List<Menu>> getMenu(){
		
		return new ResponseEntity<List<Menu>>(menuRepo.findAll() , HttpStatus.OK);
		 
	}
	
	@RequestMapping(value = "/addorder" ,method = RequestMethod.POST)
	public ResponseEntity<Orders> ordersPost(@RequestBody Orders orders)
	{
		//return new ResponseEntity<Restaurant>(restaurantRepo.findTablesById(restaurant.getRestaurantId()),HttpStatus.OK);
		return new ResponseEntity<Orders>(ordersRepo.save(orders),  HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/feedback" ,method = RequestMethod.POST)
	public ResponseEntity<Feedback> feedbackPost(@RequestBody Feedback feedback)
	{
		//return new ResponseEntity<Restaurant>(restaurantRepo.findTablesById(restaurant.getRestaurantId()),HttpStatus.OK);
		return new ResponseEntity<Feedback>(feedbackRepo.save(feedback),  HttpStatus.CREATED);
		
	}
	

	
	
	@RequestMapping(value = "/showcustomers" ,method = RequestMethod.GET)
	public List<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}
	
	
	
	
	@RequestMapping(value = "/addrestaurant" ,method = RequestMethod.POST)
	public ResponseEntity<Restaurant> postRestaurantData(@RequestBody Restaurant restaurant)
	{
		
		//return new ResponseEntity<Restaurant>(restaurantRepo.findTablesById(restaurant.getRestaurantId()),HttpStatus.OK);
		return new ResponseEntity<Restaurant>(restaurantRepo.save(restaurant),  HttpStatus.CREATED);
		
	}
	
	
	
	
	
	
	
	
	
}
