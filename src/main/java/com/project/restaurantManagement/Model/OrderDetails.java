package com.project.restaurantManagement.Model;

import javax.persistence.Entity;


public class OrderDetails {

	 private String item_quantity;
	 private double total_price;
	public String getItem_quantity() {
		return item_quantity;
	}
	public void setItem_quantity(String item_quantity) {
		this.item_quantity = item_quantity;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	 
}
