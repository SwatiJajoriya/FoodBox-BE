package com.simplilearn.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class User {
	
      @Id
  	@GeneratedValue(strategy = GenerationType.IDENTITY)
  	private int id;
    private String name;
	private String username;
	private String password;
	private String email;
	private String mobileNo;
	private String address;
	
	
     
}