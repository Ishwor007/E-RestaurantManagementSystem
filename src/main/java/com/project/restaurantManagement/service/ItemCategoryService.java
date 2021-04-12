package com.project.restaurantManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restaurantManagement.Database.ItemDao;
import com.project.restaurantManagement.Model.ItemCategory;

@Service
public class ItemCategoryService {

	@Autowired
	private ItemDao itemdao;
	  
	public ItemCategory getItemCategory(ItemCategory itemcategory) {
		
		return null;
	}
}
