package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PhotoDao;
import com.example.demo.model.Photo;
import com.example.demo.model.User;
import com.example.demo.service.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService{
	
	@Autowired
	private PhotoDao photoDao;
	
	public Photo save(Photo photo) {
		return photoDao.save(photo);
	}
	
	public List<Photo> findPhotoByUser(User user){
		return photoDao.findByUser(user);
	}
}
