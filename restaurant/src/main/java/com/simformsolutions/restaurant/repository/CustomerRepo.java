package com.simformsolutions.restaurant.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.simformsolutions.restaurant.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>{

	Customer findByEmail(String Email);

	Object findByPassword(String password);

}
