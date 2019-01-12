package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public ModelAndView list(Model model){
		model.addAttribute("userList",userRepository);
		model.addAttribute("title", "userControl");
		return new ModelAndView("users/list","userModel",model);
	}
}
