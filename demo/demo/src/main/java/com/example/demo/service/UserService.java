package com.example.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.domain.User;

public interface UserService {
	User register(User user);

	User saveUpdate(User user);

	void remove(Long id);

	Optional<User> getUser(Long id);

	Page<User> listUser(String name, Pageable pageable);
}
