package com.project.restaurantManagement.Database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.restaurantManagement.Model.Item;
import com.project.restaurantManagement.Model.ItemCategory;


public interface ItemDao {
  public void addDataItem(Item item);
  public int getItemCategory(String categoryname);
  public void saveItem(Item item);
  public ItemCategory getItemCategory(int category_id);
  public Page<Item> findPage(int page, int page_size);

}
