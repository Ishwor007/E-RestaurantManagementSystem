package com.project.restaurantManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.restaurantManagement.Model.OrderItem;

@Repository
public interface OrderRepo extends JpaRepository<OrderItem, Integer> {
}
