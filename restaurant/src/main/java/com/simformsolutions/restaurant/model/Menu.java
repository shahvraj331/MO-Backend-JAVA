package com.simformsolutions.restaurant.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long menuId;
	private String name;
	private int price;
	private int quantity;
	private int frequency;
	private String imageUrl;

	@ManyToMany
	@JoinTable(name = "order_item", joinColumns = @JoinColumn(name = "menuId"),inverseJoinColumns = @JoinColumn(name = "ordersId"))
	private List<Orders> orders;

	public Menu()
	{}
	
	public Menu(long menuId, String name, int price, int quantity, int frequency, List<Orders> orders, String imageUrl) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.frequency = frequency;
		this.orders = orders;
		this.imageUrl = imageUrl;
	}

	public Menu(String name2, int price2, int quantity2, int frequency2, String imageUrl2) {
		this.name = name2;
		this.price = price2;
		this.quantity = quantity2;
		this.frequency = frequency2;
		this.imageUrl = imageUrl2;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	

}
