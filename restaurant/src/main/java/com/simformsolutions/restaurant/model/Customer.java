package com.simformsolutions.restaurant.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String name;
	private String email;
	private String password;

	//One Customer Has Many Feedbacks
	@OneToMany(targetEntity = Feedback.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fkCustomerId", referencedColumnName = "customerId")
	private List<Feedback> customerFeedbacks;

	public Customer(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Customer() {
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}