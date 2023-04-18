package com.simplilearn.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.demo.model.Cuisine;
import com.simplilearn.demo.repo.CuisineRepo;

@Service
public class CuisineService {
@Autowired
CuisineRepo repo;

	public Cuisine insert(Cuisine c) {
		return repo.save(c);
	}
	
	public List<Cuisine> findAll(){
		return repo.findAll();
	}
}