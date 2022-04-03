package com.simformsolutions.restaurant.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long feedbackId;
	private int rating;
	private String description;

	// One Customer Has One Feedbacks
	@OneToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
	private Customer customerFeedback;

	public Feedback() {
	}

	public Feedback(long feedbackId, int rating, String description, Customer customerFeedback) {
		super();
		this.feedbackId = feedbackId;
		this.rating = rating;
		this.description = description;
		this.customerFeedback = customerFeedback;
	}

	public Feedback(int rating2, String description2) {
		this.rating = rating2;
		this.description = description2;
	}

	public Feedback(int rating2, String description2, Customer cust) {
		this.rating = rating2;
		this.description = description2;
		this.customerFeedback = cust;
	}


	public Customer getCustomerFeedback() {
		return customerFeedback;
	}

	public void setCustomerFeedback(Customer customerFeedback) {
		this.customerFeedback = customerFeedback;
	}

	public long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
