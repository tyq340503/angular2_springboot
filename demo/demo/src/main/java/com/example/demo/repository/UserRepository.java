package com.example.demo.repository;

import java.util.List;

import com.example.demo.domain.User;

public interface UserRepository {
	public void addUser();
	public void deleteUser(Long id);
	public User getUser(Long id);
	public List<User> getUserList();
}
