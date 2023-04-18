package com.simplilearn.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simplilearn.demo.model.FoodItem;
import com.simplilearn.demo.repo.FoodRepo;

@Service
public class FoodService {
@Autowired
FoodRepo repo;

public FoodItem insert(FoodItem f) {
	return repo.save(f);
}

public List<FoodItem> findAll(){
	return repo.findAll();
}
public FoodItem findById(int id) {
	return repo.findBbyId(id);
}

public FoodItem updateFood(int id, FoodItem newFd) {
	if(repo.findById(id).isPresent()) {
		FoodItem oldfd= repo.findById(id).get();
		oldfd.setFood_name(newFd.getFood_name());
		oldfd.setCuisine(newFd.getCuisine());
		oldfd.setFood_price(newFd.getFood_price());
		oldfd.setImagePath(newFd.getImagePath());
		return repo.save(oldfd);
	}
	else {
		return null;
	}
}


public boolean deleteFood(int id) {
	if(repo.findById(id).isPresent()) {
		repo.deleteById(id);
		return true;
		}
	else {
		return false;
		}
}

public List<FoodItem> findBySearch(String keyword){
	return repo.findBySearch(keyword);
}

public List<FoodItem> findByCuisine(String keyword){
	return repo.findByCuisine(keyword);
}

public List<FoodItem> sortAsc(){
	return repo.sortASC();
}

public List<FoodItem> sortDESC(){
	return repo.sortDESC();
}

}