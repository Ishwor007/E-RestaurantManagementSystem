package com.project.restaurantManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.restaurantManagement.Model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{

	 
}
