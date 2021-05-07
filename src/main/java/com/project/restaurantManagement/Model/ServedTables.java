package com.project.restaurantManagement.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ServedTables {

	@Id
	@GeneratedValue
	private int served_id;
	private int order_id;
	private String order_time;
	private int tablenumber;
	private int item_quantity;
	private Double total_price;
	 
	@ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Item.class)
	@JoinColumn(name = "item_id",referencedColumnName = "item_id")
	private Item Item;

	public Item getItem() {
		return Item;
	}

	public void setItem(Item item) {
		Item = item;
	}
	
	

	public int getOrder_id() {
		return order_id;
	}
	
	public String getOrder_time() {
		return order_time;
	}

	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getTablenumber() {
		return tablenumber;
	}
	public void setTablenumber(int tablenumber) {
		this.tablenumber = tablenumber;
	}
	
	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public int getItem_quantity() {
		return item_quantity;
	}
	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}
	
	
}

