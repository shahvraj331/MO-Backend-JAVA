package com.simformsolutions.restaurant.repository;

import com.simformsolutions.restaurant.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepo extends JpaRepository<Table, Long> {
}
