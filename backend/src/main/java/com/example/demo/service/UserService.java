package com.example.demo.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
//@Repository
public interface UserService {
	User save(User user);
	
	User findByUserName(String userName);
}
