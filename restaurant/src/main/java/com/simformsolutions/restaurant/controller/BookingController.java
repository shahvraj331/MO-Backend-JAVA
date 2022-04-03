package com.simformsolutions.restaurant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simformsolutions.restaurant.model.DiningTable;
import com.simformsolutions.restaurant.model.Feedback;
import com.simformsolutions.restaurant.model.Menu;
import com.simformsolutions.restaurant.model.Orders;
import com.simformsolutions.restaurant.repository.CustomerRepo;
import com.simformsolutions.restaurant.repository.FeedbackRepo;
import com.simformsolutions.restaurant.repository.MenuRepo;
import com.simformsolutions.restaurant.repository.OrdersRepo;
import com.simformsolutions.restaurant.repository.TableRepo;

@RestController
public class BookingController {

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

	@RequestMapping(value = "/getTable", method = RequestMethod.GET)
	public ResponseEntity<List<DiningTable>> getTableDetails() {
		return new ResponseEntity<List<DiningTable>>(tableRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/createTable", method = RequestMethod.POST)
	public ResponseEntity<DiningTable> createDiningTable(@RequestParam("size") long size,
			@RequestParam("status") String status) {

		return new ResponseEntity<DiningTable>(tableRepo.save(new DiningTable(size, status)), HttpStatus.OK);
	}

	@RequestMapping(value = "/updateTable/{id}", method = RequestMethod.PUT)
	public ResponseEntity<DiningTable> updateDiningTable(@PathVariable("id") long id,
			@RequestParam("status") String status) {

		DiningTable exDiningTable = tableRepo.findById(id).orElse(null);
		exDiningTable.setStatus(status);

		return new ResponseEntity<DiningTable>(tableRepo.saveAndFlush(exDiningTable), HttpStatus.OK);
	}

	@RequestMapping(value = "/getMenu", method = RequestMethod.GET)
	public ResponseEntity<List<Menu>> getMenu() {
		return new ResponseEntity<List<Menu>>(menuRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/addMenu", method = RequestMethod.POST)
	public ResponseEntity<Menu> menuPost(@RequestParam("name") String name, @RequestParam("price") int price,
			@RequestParam("quantity") int quantity, @RequestParam("frequency") int frequency,
			@RequestParam("imageUrl") String imageUrl) {
		Menu menu = new Menu(name, price, quantity, frequency, imageUrl);
		// return new
		// ResponseEntity<Restaurant>(restaurantRepo.findTablesById(restaurant.getRestaurantId()),HttpStatus.OK);
		return new ResponseEntity<Menu>(menuRepo.save(menu), HttpStatus.CREATED);

	}

	@RequestMapping(value = "/addorder", method = RequestMethod.POST)
	public ResponseEntity<Orders> ordersPost(@RequestParam("menuId") List<Long> ids , @RequestParam("name") List<String> names,
			@RequestParam("price") List<Integer> prices, @RequestParam("quantity") List<Integer> quantities,
			@RequestParam("frequency") List<Integer> frequencies, @RequestParam("imageUrl") List<String> imageUrls) {
		// return new
		// ResponseEntity<Restaurant>(restaurantRepo.findTablesById(restaurant.getRestaurantId()),HttpStatus.OK);
		int size = frequencies.size();
		ArrayList<Menu> menus = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			Menu menu = new Menu();
			menu.setMenuId(ids.get(i));
			menu.setFrequency(frequencies.get(i)+1);
			menu.setImageUrl(imageUrls.get(i));
			menu.setName(names.get(i));
			menu.setPrice(prices.get(i));
			menu.setQuantity(quantities.get(i));
			
			menus.add(menu);
		}
		Orders orders = new Orders();
		orders.setMenu(menus);
		return new ResponseEntity<Orders>(ordersRepo.save(orders), HttpStatus.CREATED);

	}
	
	@RequestMapping(value = "/feedback/{customerId}" ,method = RequestMethod.POST)
	public ResponseEntity<Feedback> feedbackPost(@PathVariable("customerId") long customerId, @RequestParam("rating") int rating, @RequestParam("description") String description)
	{
		Feedback feedback = new Feedback(rating,description,customerRepo.findById(customerId).orElse(null));
		//return new ResponseEntity<Restaurant>(restaurantRepo.findTablesById(restaurant.getRestaurantId()),HttpStatus.OK);
		return new ResponseEntity<Feedback>(feedbackRepo.save(feedback),  HttpStatus.CREATED);
		
	}

}
