package com.project.restaurantManagement.Database;

import com.project.restaurantManagement.Model.Item;
import com.project.restaurantManagement.Model.ItemCategory;


public interface ItemDao {
  public void addDataItem(Item item);
  public int getItemCategory(String categoryname);
  public void saveItem(Item item);
  public ItemCategory getItemCategory(int category_id);

}
