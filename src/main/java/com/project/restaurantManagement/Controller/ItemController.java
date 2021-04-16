package com.project.restaurantManagement.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.restaurantManagement.Database.ItemDao;
import com.project.restaurantManagement.Model.Item;
import com.project.restaurantManagement.Model.ItemCategory;
import com.project.restaurantManagement.Repository.ItemCategoryRepo;



@Controller
public class ItemController {

	
	@Autowired
	private ItemDao itemdao;
	@Autowired
	private ItemCategoryRepo itemcategoryrepo;
	
	//placing a data by the admin in the database
	
	@PostMapping("/file")
	public String saveDataItem(@RequestParam("file") MultipartFile file,Item item,ItemCategory item_category){
    String img_name = file.getOriginalFilename();
try {
	byte[] b = file.getBytes();
   Path path = Paths.get("/home/seetal/Documents/workspace-spring-tool-suite-4-4.6.0.RELEASE/RestaurantManagement/src/main/webapp/photos/"+img_name);
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
		  
		  // itemrepo.save(item);
		   return "dataentry";
	 }
	  
	
	}	
	
	
	//Fetching the item from the database
	
//	public Page<Item> getPage() {
//		
//		
//		
//		
//		return  ;
//	}
	
	
	
	
}
