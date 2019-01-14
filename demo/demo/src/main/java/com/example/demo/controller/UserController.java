package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public ModelAndView list(Model model) {
		model.addAttribute("userList", userRepository.findAll());
		model.addAttribute("title", "userControl");
		return new ModelAndView("users/list", "userModel", model);
	}

	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id, Model model) {
		Optional<User> user = userRepository.findById(id);
		model.addAttribute("user ", user);
		model.addAttribute("title", "userControl");
		return new ModelAndView("users/view", "userModel", model);
	}

	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user ", new User((Long) null,null,null));
		model.addAttribute("title", "userControl");
		return new ModelAndView("users/form", "userModel", model);
	}

	@PostMapping("/form")
	public ModelAndView saveOrUpdateUser(User user) {
		userRepository.save(user);
		return new ModelAndView("redirect:/users");
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
		return new ModelAndView("redirect:/users");
	}

	@GetMapping("/form")
	public ModelAndView modify(@PathVariable("id") Long id, Model model) {
		Optional<User> user = userRepository.findById(id);
		model.addAttribute("user ", user);
		model.addAttribute("title", "modify user");
		return new ModelAndView("users/form", "userModel", model);
	}
}
