package com.simplilearn.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.demo.model.Cuisine;

public interface CuisineRepo extends JpaRepository<Cuisine, Integer> {

}