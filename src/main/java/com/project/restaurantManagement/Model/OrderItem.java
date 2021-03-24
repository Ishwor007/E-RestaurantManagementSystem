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
	private int order_qty;
	private int table_no;
	
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
	public int getOrder_qty() {
		return order_qty;
	}
	public void setOrder_qty(int order_qty) {
		this.order_qty = order_qty;
	}
	public int getTable_no() {
		return table_no;
	}
	public void setTable_no(int table_no) {
		this.table_no = table_no;
	}
	
	
	
}
