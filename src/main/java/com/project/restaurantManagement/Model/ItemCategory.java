package com.project.restaurantManagement.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItemCategory {
    @Id
    @GeneratedValue
	 private int pc_id;
	 private String pc_name;
	 private String pcimg_location;
	 
	public int getPc_id() {
		return pc_id;
	}
	public void setPc_id(int pc_id) {
		this.pc_id = pc_id;
	}
	public String getPc_name() {
		return pc_name;
	}
	public void setPc_name(String pc_name) {
		this.pc_name = pc_name;
	}
	
	
	
	
	public String getPcimg_location() {
		return pcimg_location;
	}
	public void setPcimg_location(String pcimg_location) {
		this.pcimg_location = pcimg_location;
	}
	@Override
	public String toString() {
		return "ProductCategory [pc_id=" + pc_id + ", pc_name=" + pc_name + "]";
	}
	 
}
