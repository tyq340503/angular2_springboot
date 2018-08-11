package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Photo;
import com.example.demo.model.User;

public interface PhotoService {
	Photo save(Photo photo);
	
	List<Photo> findPhotoByUser(User user);
}
