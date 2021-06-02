package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void save(User book) {
		sessionFactory.getCurrentSession().save(book);
	}

	public User get(long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}


}
