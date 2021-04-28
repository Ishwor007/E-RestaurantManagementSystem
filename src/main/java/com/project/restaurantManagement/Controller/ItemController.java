package com.project.restaurantManagement.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.restaurantManagement.Database.ItemDao;
import com.project.restaurantManagement.Model.Item;
import com.project.restaurantManagement.Model.ItemCategory;
import com.project.restaurantManagement.Repository.ItemCategoryRepo;



@Controller
public class ItemController {
 private String cname;
	
	@Autowired
	private ItemDao itemdao;
	
	
	@GetMapping("/")
	 public String getHomePages(Model model) {
		 return getPage(1, model);
	 }
	
	
	//placing a data by the admin in the database
	
	@PostMapping("/file")
	public String saveDataItem(@RequestParam("file") MultipartFile file,Item item,ItemCategory item_category){
    String img_name = file.getOriginalFilename();
try {
	byte[] b = file.getBytes();
   Path path = Paths.get("/home/seetal/Desktop/RestaurantManagement/src/main/resources/static/photos/"+img_name);
   System.out.println(img_name);
   Files.write(path, b);

}catch(Exception e) {}

     item.setImg_name(img_name);
     int categoryid=itemdao.getItemCategory(item_category.getPc_name());
	 if(categoryid==0) {
		   System.out.println(item.getItem_price());
		   item.setItem_category(item_category);
		  itemdao.addDataItem(item);
		   return "dataentry";
	 }
	 else {
		   
		  ItemCategory icategory = itemdao.getItemCategory(categoryid);
		  item.setItem_category(icategory);
		  itemdao.saveItem(item);
		  return "dataentry";
	 }
	  
	}	
	
	
	//Fetching the item from the database
	
	@GetMapping("/home/{page}")
	public String getPage(@PathVariable("page") int page,Model model) {
		int page_size=6;
		String condition="yes";
		List<ItemCategory> item_c=itemdao.getItemCategory();
		Page<Item> pages = itemdao.findPage(page,page_size);
		List<Item> item_list = pages.getContent();
		model.addAttribute("currentpage",page);
		model.addAttribute("totalpage",pages.getTotalPages());
		model.addAttribute("totalelement",pages.getTotalElements());
		model.addAttribute("item_list",item_list);
		model.addAttribute("itemcategory_list",item_c);
		model.addAttribute("condition", condition);
		System.out.println(page);
		System.out.println(pages.getTotalPages());
		
	    return "home";
		
	}
	@GetMapping("home/items/{page}")
	public String getItemByCategory(@PathVariable("page") int page,Model model) {
	  int page_size=6;
	  String condition="no";
	  
	  List<ItemCategory> item_c=itemdao.getItemCategory();
		Page<Item> pages = itemdao.FindPageByName(cname, page, page_size);
		
		List<Item> item_list = pages.getContent();
		
		model.addAttribute("currentpage",page);
		model.addAttribute("totalpage",pages.getTotalPages());
		model.addAttribute("totalelement",pages.getTotalElements());
		model.addAttribute("item_list",item_list);
		model.addAttribute("itemcategory_list",item_c);
		model.addAttribute("condition",condition);
		return "home";
	}
	@GetMapping("home/item/{cname}")
	public String getItemByPage(@PathVariable("cname") String cname,Model model) {
		this.cname=cname;
		return getItemByCategory( 1, model);
	}
	
}
