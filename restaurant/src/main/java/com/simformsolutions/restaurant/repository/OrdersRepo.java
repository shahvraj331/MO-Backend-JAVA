package com.simformsolutions.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simformsolutions.restaurant.model.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Long>{

}
