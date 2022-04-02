package com.simformsolutions.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simformsolutions.restaurant.model.Menu;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Long>{

}
