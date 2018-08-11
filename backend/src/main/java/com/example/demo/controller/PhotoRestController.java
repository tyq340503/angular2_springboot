package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.model.Photo;
import com.example.demo.model.User;
import com.example.demo.service.PhotoService;

@RestController
@RequestMapping("/rest")
public class PhotoRestController {
	
	private String photoName;
	
	@Autowired
	private PhotoService photoService;
	
	@RequestMapping(value="/photo/upload",method=RequestMethod.POST)
	public String uploadPhoto(HttpServletResponse response,HttpServletRequest request){
		MultipartHttpServletRequest mutipartFile = (MultipartHttpServletRequest) request;
		Iterator<String> it =  mutipartFile.getFileNames();
		MultipartFile file = mutipartFile.getFile(it.next());
		String filename = file.getOriginalFilename();
		photoName = filename;
		String path = new File("src/main/resources/static/img").getAbsolutePath()+'\\'+filename;
		try{
			file.transferTo(new File(path));
		}catch(IOException e){
			e.printStackTrace();
			return "upload fail";
		}
		
		return "upload success";
	}
	
	@RequestMapping(value="/photo/add",method=RequestMethod.POST)
	public Photo addPhoto(@RequestBody Photo photo){
		photo.setPhotoName(photoName);
		return photoService.save(photo);
	}
	
	@RequestMapping(value="/photo/user",method=RequestMethod.POST)
	public List<Photo> getPhotoByUser(@RequestBody User user){
		
		return photoService.findPhotoByUser(user);
	}
	
}
