package com.spring.controller;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.User;
import com.spring.service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private Logger logger = LogManager.getLogger(UserController.class);
	
	
	
	@PostMapping("/api/user")
	public ResponseEntity<?> save(@RequestBody User book){
		
		if (logger.isDebugEnabled()) {
			logger.debug("Login Method");
		}
		try
		{
		String response=userService.save(book);
		
		return ResponseEntity.status(201).body(response);
		}
		catch(Throwable e)
				{
					
						UUID uuid = UUID.randomUUID();
						return ResponseEntity.ok().body("");
					}
	}
	
	@GetMapping("/api/user/{id}")
	public ResponseEntity<User> get(@PathVariable long id){
		if(logger.isDebugEnabled()){
			logger.debug("Entered get book method : {}",id);
			logger.debug("Book id : {}",id);
		}
		User user = userService.get(id);
		
		return ResponseEntity.ok().body(user);
	}
	

}
