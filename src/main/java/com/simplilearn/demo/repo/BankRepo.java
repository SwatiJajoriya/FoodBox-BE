package com.simplilearn.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.demo.model.BankDetails;

public interface BankRepo extends JpaRepository<BankDetails, Integer> {
	@Query("Select b.balance from BankDetails b where b.bankname=?1")
public int findBalanceByName(String bname);
	
	@Query("Select bd.balance from BankDetails bd where bd.bid=?1")
	public int findBalanceByID(int bid);
}