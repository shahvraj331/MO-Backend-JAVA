package com.simformsolutions.restaurant.model;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ordersId;
	
	@OneToMany(targetEntity = Menu.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fkOrdersId", referencedColumnName = "ordersId")
	private List<Menu> ordersMenu;
	
	
}
