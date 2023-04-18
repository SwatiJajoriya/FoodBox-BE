package com.simplilearn.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.demo.model.User;

public interface UserRepo extends JpaRepository<User, String> {
	
	
	@Query("Select u from User u where u.username=?1")
	public User findByName(String uname);

}