package com.project.restaurantManagement.Model;


import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {
 
	@Id
	@GeneratedValue
	private int order_id;
	private Time order_time;
	private int tablenumber;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Time getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Time order_time) {
		this.order_time = order_time;
	}
	
	
	
	
}
