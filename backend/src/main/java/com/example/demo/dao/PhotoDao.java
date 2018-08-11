package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Photo;
import com.example.demo.model.User;

public interface PhotoDao extends CrudRepository<Photo,Long> {
	
	Photo save(Photo photo);
	
	List<Photo> findByUser(User user);
}
