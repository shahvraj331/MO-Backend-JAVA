package com.simformsolutions.restaurant.repository;

import com.simformsolutions.restaurant.model.DiningTable;
import com.simformsolutions.restaurant.model.Restaurant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
	//public List<DiningTable> findTablesById(long id);
}
