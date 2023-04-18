package com.simplilearn.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.demo.model.BankDetails;
import com.simplilearn.demo.repo.BankRepo;

@Service
public class BankService {
@Autowired
BankRepo repo;


public BankDetails insert(BankDetails bd) {
	return repo.save(bd);
}

public int findBalanceById(int id) {
	return repo.findBalanceByID(id);
}
public int findBalanceByBname(String bname) {
	return repo.findBalanceByName(bname);
}
}