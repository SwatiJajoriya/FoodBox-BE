package com.simplilearn.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.demo.model.Cart;
import com.simplilearn.demo.repo.CartRepository;

@Service
public class CartService {
@Autowired
CartRepository repo;

public Cart insert(Cart c) {
	return repo.save(c);
}
public List<Cart> findAll(){
	return repo.findAll();
}
public boolean deleteAllFromCart() {
	repo.deleteAll();
	
		return true;
	
}

}