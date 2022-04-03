package com.simformsolutions.restaurant.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ordersId;
	
	@ManyToMany(mappedBy="orders")
	private List<Menu> menu;

	public Orders(){}
	
	public Orders(long ordersId, List<Menu> menu) {
		super();
		this.ordersId = ordersId;
		this.menu = menu;
	}

	public long getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(long ordersId) {
		this.ordersId = ordersId;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	
	
}
