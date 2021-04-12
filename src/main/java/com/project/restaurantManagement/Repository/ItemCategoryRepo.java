package com.project.restaurantManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.restaurantManagement.Model.Item;
import com.project.restaurantManagement.Model.ItemCategory;

@Repository
public interface ItemCategoryRepo extends JpaRepository<ItemCategory, Integer> {
 
}
