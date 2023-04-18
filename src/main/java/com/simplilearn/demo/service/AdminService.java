package com.simplilearn.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.demo.model.Admin;
import com.simplilearn.demo.repo.AdminRepo;

@Service
public class AdminService {
@Autowired
AdminRepo repo;


public Admin insert(Admin a) {
	return repo.save(a);
}

public Admin findByUsername(String username) {
	return repo.findByName(username);
}
}