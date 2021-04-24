package com.project.restaurantManagement.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.restaurantManagement.Model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{
	
@Query(value = "SELECT * FROM item WHERE itemcategory_id =:pcid ",nativeQuery = true)
 public Page<Item> findAllById(Pageable pageable,int pcid);

	 
}
