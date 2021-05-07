package com.project.restaurantManagement.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.project.restaurantManagement.Database.AdminDao;
import com.project.restaurantManagement.Model.Admin;

@Controller
public class AdminController {
 
	@Autowired
	private AdminDao admindao;
	
	@GetMapping("/adminlogin")
	 public String getAdminLoginPage() {
		
		 return "adminlogin";
	 }
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String adminLogin(@ModelAttribute Admin admin,Model model) {
		admin.setAdmin_password(DigestUtils.md5DigestAsHex(admin.getAdmin_password().getBytes()));
		 Admin admindata = admindao.adminLogin(admin.getAdmin_username(), admin.getAdmin_password());
			 if(admindata!=null) {
		return "dataentry";
			 }
	  model.addAttribute("error","user doesnot exist");
	  return "adminlogin";
	}
	
	@GetMapping("/dataentry")
	 public String getdataEntryPage() {
		
		 return "adminlogin";
	 }
	
	@PostMapping("/signup")
	public String fillSignup(@ModelAttribute Admin admin) {
		
		admin.setAdmin_password(DigestUtils.md5DigestAsHex(admin.getAdmin_password().getBytes()));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now(); 
		admin.setCreation_date(dtf.format(now));
		admindao.addAdmin(admin);
		
		
		return "adminlogin";
	}
	
	@GetMapping("/signup")
	public String getSignup() {
		return "adminsignup";
	}
	
	

}
