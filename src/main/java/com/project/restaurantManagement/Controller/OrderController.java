package com.project.restaurantManagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

	@GetMapping("/home/order")
	public String getOrderPage() {
		return "order";
	}
	
}
