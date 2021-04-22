package com.project.restaurantManagement.Database;

import com.project.restaurantManagement.Model.Admin;

public interface AdminDao {

	 public Admin adminLogin(String admin_username,String admin_password);
	 public void addAdmin(Admin admin);
	 
	 
}
