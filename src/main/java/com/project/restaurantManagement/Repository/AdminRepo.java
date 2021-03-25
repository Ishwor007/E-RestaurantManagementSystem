package com.project.restaurantManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.restaurantManagement.Model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {

}
