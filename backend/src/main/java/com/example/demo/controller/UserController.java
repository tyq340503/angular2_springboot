package com.example.demo.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

//@Component 
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public User registerUser(@RequestBody User user){
		return userService.save(user);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestBody Map<String,String> data) throws ServletException {
		String checkname = data.get("username");
		String password = data.get("password");
		User checkuser = userService.findByUserName(checkname);
		String checkpassword = checkuser.getPassword();
		
		if(checkuser == null || !password.equals(checkpassword)){
			throw new ServletException("user or password is not correct");
		}
		
		return Jwts.builder().setSubject(checkname).claim("roles", "checkuser").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
	}

}
