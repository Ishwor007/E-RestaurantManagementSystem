package com.project.restaurantManagement.Model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private int item_id;
	private String item_name;
	private String item_price;
	private String img_name;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = ItemCategory.class)
	@JoinColumn(name = "itemcategory_id",referencedColumnName = "pc_id")
	private ItemCategory item_category;
	
	

	public ItemCategory getItem_category() {
		return item_category;
	}
	public void setItem_category(ItemCategory item_category) {
		this.item_category = item_category;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_price() {
		return item_price;
	}
	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	
	

}
