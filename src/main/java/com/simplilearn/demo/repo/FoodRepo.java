package com.simplilearn.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.demo.model.FoodItem;

public interface FoodRepo extends JpaRepository<FoodItem, Integer>{
	@Query("Select f from FoodItem f where f.food_name LIKE %?1%"+"OR f.cuisine LIKE %?1%")
	public List<FoodItem> findBySearch(String keyword);
	
	@Query("Select f from FoodItem f where f.cuisine=?1")
	public List<FoodItem> findByCuisine(String Keyword);
	
	@Query("Select f from FoodItem f where f.id=?1")
	public FoodItem findBbyId(int id);
	
	@Query("Select f from FoodItem f ORDER BY f.food_price ASC")
	public List<FoodItem> sortASC();
	
	@Query("Select f from FoodItem f ORDER BY f.food_price DESC")
	public List<FoodItem> sortDESC();
}