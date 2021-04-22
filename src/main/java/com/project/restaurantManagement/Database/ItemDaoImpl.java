package com.project.restaurantManagement.Database;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	@Override
	public void saveItem(Item item) {
	itemrepo.save(item);	
	}

	@Override
	public ItemCategory getItemCategory(int category_id) {
		return itemcategoryrepo.getOne(category_id);
	}

	@Override
	public Page<Item> findPage(int page, int page_size) {
		Pageable pageable = PageRequest.of(page-1, page_size);
		System.out.println(pageable);
		return itemrepo.findAll(pageable);
	}

	
	
  
	
	
}
