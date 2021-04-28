package com.project.restaurantManagement.Database;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.restaurantManagement.Model.Item;
import com.project.restaurantManagement.Model.ItemCategory;
import com.project.restaurantManagement.Model.OrderItem;


public interface ItemDao {
  public void addDataItem(Item item);
  public int getItemCategory(String categoryname);
  public Item getItem(int id);
  public void saveItem(Item item);
  public ItemCategory getItemCategory(int category_id);
  public Page<Item> findPage(int page, int page_size);
  public List<ItemCategory> getItemCategory();
  public Page<Item> FindPageByName(String cname,int page, int page_size);
  public void saveOrderDetails(OrderItem orderitem);
  public List<OrderItem> getAllOrderItem();
  public void serverdItem(int order_id);

  
}
