package com.simplilearn.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.demo.model.Admin;
import com.simplilearn.demo.model.BankDetails;
import com.simplilearn.demo.model.Cart;
import com.simplilearn.demo.model.Cuisine;
import com.simplilearn.demo.model.FoodItem;
import com.simplilearn.demo.model.User;
import com.simplilearn.demo.service.AdminService;
import com.simplilearn.demo.service.BankService;
import com.simplilearn.demo.service.CartService;
import com.simplilearn.demo.service.CuisineService;
import com.simplilearn.demo.service.FoodService;
import com.simplilearn.demo.service.UserService;

@RestController
@RequestMapping("/api/v1/")
public class RestFulController {
@Autowired
AdminService adao;
@Autowired
BankService bdao;
@Autowired
CartService cadao;
@Autowired
UserService udao;
@Autowired
FoodService fdao;
@Autowired
CuisineService cudao;
			//////////////FoodItem/////////////
@PostMapping("/fooditems/addFood")
public ResponseEntity<FoodItem> addFood(@RequestBody FoodItem f) {
	FoodItem mm=fdao.insert(f);
	if(mm!=null) {
		return new ResponseEntity<FoodItem>(mm,HttpStatus.CREATED);
	}
		else {
			return new ResponseEntity<FoodItem>(mm,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@DeleteMapping("/fooditems/foodDelete/{id}")
public ResponseEntity<String>deleteFood(@PathVariable int id){
	boolean result = fdao.deleteFood(id);
	if(result) 
		return new ResponseEntity<String>("Object Deleted",HttpStatus.OK);
	else
		return new ResponseEntity<String>("NO movie Found", HttpStatus.NOT_FOUND);
	
}
@PutMapping("/fooditems/foodUpdate/{id}")
public ResponseEntity<Object> updateFood(@PathVariable int id,@RequestBody FoodItem newfd){
	FoodItem fd= fdao.updateFood(id, newfd);
	
	if (fd!=null)
		return new ResponseEntity<Object>(fd,HttpStatus.OK);
	else
		return new ResponseEntity<Object>("No Movie Available to Update",HttpStatus.NOT_FOUND);
}
@GetMapping("fooditems/getAllFood")
public List<FoodItem> getAllFood(){
	return fdao.findAll();
}
@GetMapping("fooditems/getFoodById/{id}")
public FoodItem getFoodById(@PathVariable int id){
	return fdao.findById(id);
}
@GetMapping("fooditems/getAllFoodByASC")
public List<FoodItem> getAllFoodASC(){
	return fdao.sortAsc();
}
@GetMapping("fooditems/getAllFoodByDESC")
public List<FoodItem> getAllFoodDESC(){
	return fdao.sortDESC();
}
@GetMapping("fooditems/getAllFoodBySearch/{keyword}")
public List<FoodItem> getAllFoodBySearch(@PathVariable String keyword){
	return fdao.findBySearch(keyword);
}
@GetMapping("fooditems/getAllFoodByCuisine/{keyword}")
public List<FoodItem> getAllFoodByCuisine(@PathVariable String keyword){
	return fdao.findByCuisine(keyword);
}

			///////Cuisine////////
@GetMapping("cuisine/getAllCuisine")
public List<Cuisine> getAllCuisine(){
	return cudao.findAll();
}
@PostMapping("cuisine/addCuisine")
public ResponseEntity<Cuisine> addCuisine(@RequestBody Cuisine f) {
	Cuisine mm=cudao.insert(f);
	if(mm!=null) {
		return new ResponseEntity<Cuisine>(mm,HttpStatus.CREATED);
	}
		else {
			return new ResponseEntity<Cuisine>(mm,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
			//////Admin////////   
@PostMapping("admin/addAdmin")
public ResponseEntity<Admin> addAdmin(@RequestBody Admin f) {
	Admin mm=adao.insert(f);
	if(mm!=null) {
		return new ResponseEntity<Admin>(mm,HttpStatus.CREATED);
	}
		else {
			return new ResponseEntity<Admin>(mm,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping("admin/getAdminByUsername/{username}")
public Admin getAdmin(@PathVariable String username){
	return adao.findByUsername(username);
}
			//////User////////   
@PostMapping("user/addUser")
public ResponseEntity<User> addUser(@RequestBody User f) {
	User mm=udao.insert(f);
if(mm!=null) {
	return new ResponseEntity<User>(mm,HttpStatus.CREATED);
}
	else {
		return new ResponseEntity<User>(mm,HttpStatus.INTERNAL_SERVER_ERROR);
}
}
@GetMapping("user/getUserByUsername/{username}")
public User getUser(@PathVariable String username){
return udao.findByUsername(username);
}
			////////Bank///////
@PostMapping("bank/addBank")
public ResponseEntity<BankDetails> addBank(@RequestBody BankDetails bd) {
	BankDetails mm=bdao.insert(bd);
if(mm!=null) {
	return new ResponseEntity<BankDetails>(mm,HttpStatus.CREATED);
}
	else {
		return new ResponseEntity<BankDetails>(mm,HttpStatus.INTERNAL_SERVER_ERROR);
}
}
@GetMapping("bank/getBankDetails/{id}")
public int getBankById(@PathVariable int id){
return bdao.findBalanceById(id);
}
@GetMapping("bank/getBankDetailsByBname/{bname}")
public int getBankByBname(@PathVariable String bname){
return bdao.findBalanceByBname(bname);
}

			///////cart////////////
@PostMapping("cart/addToCart")
public ResponseEntity<Cart> addToCart(@RequestBody Cart bd) {
	Cart mm=cadao.insert(bd);
if(mm!=null) {
	return new ResponseEntity<Cart>(mm,HttpStatus.CREATED);
}
	else {
		return new ResponseEntity<Cart>(mm,HttpStatus.INTERNAL_SERVER_ERROR);
}
}
@GetMapping("cart/getAllCart")
public List<Cart> getCart(){
return cadao.findAll();
}
@DeleteMapping("cart/flush")
public ResponseEntity<String>deleteAllFromCart(){
	boolean result = cadao.deleteAllFromCart();
	if(result) 
		return new ResponseEntity<String>("Object Deleted",HttpStatus.OK);
	else
		return new ResponseEntity<String>("NO movie Found", HttpStatus.NOT_FOUND);
	
}
}