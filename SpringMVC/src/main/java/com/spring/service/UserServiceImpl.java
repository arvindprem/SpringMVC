package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.UserDAO;
import com.spring.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Transactional
	public String save(User user) {
		if("France".equalsIgnoreCase(user.getCountry())){
		  if(user.getAge()>18){
		    userDAO.save(user);
		    return "User can created successfully";
           } 
	    	else
	    	{
			return "adults with age greater than 18  only can create an account";
		   }
		}
		else{
			return "France adults only can create an account";
		}
	}

	@Transactional
	public User get(long id) {
		return userDAO.get(id);
	}

	
}
