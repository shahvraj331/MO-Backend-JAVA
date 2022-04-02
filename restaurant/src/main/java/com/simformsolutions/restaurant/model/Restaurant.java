package com.simformsolutions.restaurant.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long restaurantId;
    private String name;
    private String address;
    private String email;

    @OneToMany(targetEntity = Table.class)
    @JoinColumn(name = "fk_rId", referencedColumnName = "rId")
    private List<Table> tables;

    public Restaurant() {
    }

    public Restaurant(long rId, String name, String address, String email, List<Table> tables) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.tables = tables;
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

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
