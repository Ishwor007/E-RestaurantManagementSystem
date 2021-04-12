package com.project.restaurantManagement.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue
	 private int admin_id;
	 private String admin_firstname;
	 private String admin_lastname;
	 private String admin_username;
	 private String admin_password;
	 private String admin_phone;
	 private Date creation_date;
	 private String admin_email;
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_firstname() {
		return admin_firstname;
	}
	public void setAdmin_firstname(String admin_firstname) {
		this.admin_firstname = admin_firstname;
	}
	public String getAdmin_lastname() {
		return admin_lastname;
	}
	public void setAdmin_lastname(String admin_lastname) {
		this.admin_lastname = admin_lastname;
	}
	public String getAdmin_username() {
		return admin_username;
	}
	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public String getAdmin_phone() {
		return admin_phone;
	}
	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	 
	 
}
