package com.project.restaurantManagement.Database;

import com.project.restaurantManagement.Model.ItemCategory;

public interface ItemDao {
  public void addDataItem();
  public int getItemCategory(String categoryname);
}
