package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/rest")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/users",method=RequestMethod.GET)
	public String loginGet(){
		return "login success";
	}
	
	@RequestMapping(value="/user/username",method=RequestMethod.POST)
	public User getUser(@RequestBody String username){
		
		return userService.findByUserName(username);
	}
}
