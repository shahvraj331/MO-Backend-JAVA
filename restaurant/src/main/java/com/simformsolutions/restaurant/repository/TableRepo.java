package com.simformsolutions.restaurant.repository;

import com.simformsolutions.restaurant.model.DiningTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepo extends JpaRepository<DiningTable, Long> {
}
