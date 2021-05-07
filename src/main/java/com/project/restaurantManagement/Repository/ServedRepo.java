package com.project.restaurantManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.restaurantManagement.Model.ServedTables;
@Repository
public interface ServedRepo extends JpaRepository<ServedTables, Integer> {

}
