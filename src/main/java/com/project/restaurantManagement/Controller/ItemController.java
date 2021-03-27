package com.project.restaurantManagement.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.restaurantManagement.Database.ItemDao;
import com.project.restaurantManagement.Model.Item;
import com.project.restaurantManagement.Model.ItemCategory;
import com.project.restaurantManagement.Repository.ItemCategoryRepo;
import com.project.restaurantManagement.Repository.ItemRepo;


@RestController
public class ItemController {

	
	@Autowired
	private ItemDao itemdao;
	@Autowired
	private ItemRepo itemrepo;
	@Autowired
	private ItemCategoryRepo itemcategoryrepo;
	
	@PostMapping("/file")
	public ResponseEntity<String> saveDataItem(@RequestParam("file") MultipartFile file,Item item,ItemCategory item_category){
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
		   System.out.println("Control flow in if condition");
		   return new ResponseEntity<>("success with new Category",HttpStatus.OK);
	 }
	 else {
		   System.out.println("Control flow in else condition");
		  ItemCategory icategory = itemcategoryrepo.getOne(categoryid);
		  item.setItem_category(icategory);
		   itemrepo.save(item);
		   return new ResponseEntity<>("success with old Category",HttpStatus.OK);
	 }
	  
	
	}	
}
