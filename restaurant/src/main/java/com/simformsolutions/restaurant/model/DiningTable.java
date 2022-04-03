package com.simformsolutions.restaurant.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DiningTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tableId;
	private long size;
	private String status;

	@OneToOne(targetEntity = Orders.class, cascade = CascadeType.ALL)
	private Orders orders;

	public DiningTable() {
	}

	public DiningTable(long tableId, long size, String status, Orders orders) {
		super();
		this.tableId = tableId;
		this.size = size;
		this.status = status;
		this.orders = orders;
	}

	public DiningTable(long size2, String status2) {
		this.size = size2;
		this.status = status2;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public long getTableId() {
		return tableId;
	}

	public void setTableId(long tableId) {
		this.tableId = tableId;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
