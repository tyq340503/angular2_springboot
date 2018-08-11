package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

//@Service
@Component 
@Repository
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public User save(User user){
		
		return userDao.save(user);
	}
	
	public User findByUserName(String userName){
		return userDao.findByUserName(userName);
	}
}
