package com.simformsolutions.restaurant.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long restaurantId;
    private String name;
    private String address;
    private String email;

    @OneToMany(targetEntity = DiningTable.class)
    @JoinColumn(name = "fkRestaurantId", referencedColumnName = "restaurantId")
    private List<DiningTable> tables;
    
    @ManyToMany
	@JoinTable(name="menu_restaurant",
	joinColumns = @JoinColumn(name="restaurantId"),
	inverseJoinColumns = @JoinColumn(name="menuId"))
	private List<Menu> menus;
    
    
    
	@OneToMany(targetEntity = Orders.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fkRestaurantId", referencedColumnName = "restaurantId")
	private List<Orders> restaurantOrders;

    public Restaurant() {
    }

    public Restaurant(long restaurantId, String name, String address, String email, List<DiningTable> tables) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.tables = tables;
    }

    public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<DiningTable> getTables() {
        return tables;
    }

    public void setTables(List<DiningTable> tables) {
        this.tables = tables;
    }
}
