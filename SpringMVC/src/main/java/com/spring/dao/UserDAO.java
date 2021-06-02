package com.spring.dao;

import java.util.List;

import com.spring.model.User;

public interface UserDAO {
	// Save the record
	void save(User user);
	
	//Get a single Book
	User get(long id);
	
}
