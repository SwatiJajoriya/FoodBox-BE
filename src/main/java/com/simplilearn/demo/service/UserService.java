package com.simplilearn.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simplilearn.demo.model.User;
import com.simplilearn.demo.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo repo;
	
	public User insert(User a) {
		return repo.save(a);
	}

	public User findByUsername(String username) {
		return repo.findByName(username);
	}
}