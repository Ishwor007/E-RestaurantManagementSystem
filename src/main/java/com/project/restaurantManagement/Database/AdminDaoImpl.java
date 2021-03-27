package com.project.restaurantManagement.Database;





import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.project.restaurantManagement.Model.Admin;
import com.project.restaurantManagement.Model.Item;
import com.project.restaurantManagement.Repository.AdminRepo;

@Component
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private AdminRepo adminrepo;
	
	@Override
	@Transactional
	public Admin adminLogin(String admin_username, String admin_password) {
		List<Admin> admin_list = adminrepo.findAll();
		for(Admin admin:admin_list) {
			if(admin.getAdmin_username().equals(admin_username)&& admin.getAdmin_password().equals(admin_password)) {
				return admin;
			}
		}

		return null;
	}

	@Override
	public void addAdmin(Admin admin) {
	  adminrepo.save(admin);
		
	}

	

	 
}
