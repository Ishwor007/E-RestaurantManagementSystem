package com.project.restaurantManagement.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.restaurantManagement.Database.ItemDao;
import com.project.restaurantManagement.Model.Item;
import com.project.restaurantManagement.Model.OrderItem;

@Controller
public class OrderController {

	@Autowired
	private ItemDao itemdao;
	
	@GetMapping("/home/order")
	public String getOrderPage(Model model) {
		List<OrderItem> orderitemlist= itemdao.getAllOrderItem();
		model.addAttribute("orderitemlist",orderitemlist);
		return "orderpage";
	}
	
	 @PostMapping("/home/order/{orderid}")
	 public String saveOrderDetails(@ModelAttribute OrderItem orderitem,@PathVariable("orderid") int order_id,Model model) {
		Item item = itemdao.getItem(order_id);
		int qt=orderitem.getItem_quantity();
		double price = item.getItem_price();
		orderitem.setTotal_price(qt*price);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now(); 
		   orderitem.setOrder_time(dtf.format(now));
		 orderitem.setItem(item);
		 itemdao.saveOrderDetails(orderitem);
	List<OrderItem> orderitemlist= itemdao.getAllOrderItem();
	model.addAttribute("orderitemlist",orderitemlist);
	return "orderpage";
	}
	 
	 @GetMapping("/home/order/served/{order_id}")
	 public String servedItem(@PathVariable("order_id") int order_id,Model model) {
		 
		 itemdao.serverdItem(order_id);
			List<OrderItem> orderitemlist= itemdao.getAllOrderItem();
			model.addAttribute("orderitemlist",orderitemlist);
		 return "orderpage";
	 }
}
