package com.spring.service;

import java.util.List;

import com.spring.model.User;

public interface UserService {

	// Save the record
		String save(User user);
		
		//Get a single user
		User get(long id);
		
		
	
}
