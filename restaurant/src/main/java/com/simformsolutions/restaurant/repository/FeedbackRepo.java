package com.simformsolutions.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simformsolutions.restaurant.model.Feedback;


public interface FeedbackRepo extends JpaRepository<Feedback,Long>{

}
