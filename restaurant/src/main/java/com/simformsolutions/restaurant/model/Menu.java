package com.simformsolutions.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Menu{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long menuId;
	private String dishName;
	private String dishType;
	private int price;
	private int buyFrequency;

	public Menu(long menuId, String dishName, String dishType, int price, int buyFrequency) {
		this.menuId = menuId;
		this.dishName = dishName;
		this.dishType = dishType;
		this.price = price;
		this.buyFrequency=buyFrequency;
	}

	public long getMenuId() {
		return menuId;
	}

	public int getBuyFrequency() {
		return buyFrequency;
	}

	public void setBuyFrequency(int buyFrequency) {
		this.buyFrequency = buyFrequency;
	}

	public Menu() {
		super();
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
