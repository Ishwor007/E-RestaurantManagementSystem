package com.project.restaurantManagement.Database;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.restaurantManagement.Model.Item;
import com.project.restaurantManagement.Model.ItemCategory;
import com.project.restaurantManagement.Repository.ItemCategoryRepo;
import com.project.restaurantManagement.Repository.ItemRepo;


@Component
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private ItemCategoryRepo itemcategoryrepo;
	@Autowired
	private ItemRepo itemrepo;
	
	@Override
	public void addDataItem(Item item) {
		
		itemrepo.save(item);
	}

	@Override
	public int getItemCategory(String categoryname) {
		ItemCategory ichandling = new ItemCategory();
		List<ItemCategory> ic = itemcategoryrepo.findAll();
	
		
		for(ItemCategory icategory:ic) {
			if(icategory.getPc_name().equalsIgnoreCase(categoryname)) {
				return icategory.getPc_id();
			}
		}
		
		return 0;
	}

	
  
	
	
}
