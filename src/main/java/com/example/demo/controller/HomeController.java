package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.errors.UserErrorResponse;
import com.example.demo.exceptions.UserNotFountException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value = "user")
public class HomeController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		
		User user = userService.getUser(id);
		if(user==null)
			throw new UserNotFountException("User Details Not Found");
		 return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
//	@ExceptionHandler()
//	public ResponseEntity<?> userDetailsExceptionHandler(UserNotFountException exception){
//		UserErrorResponse error=new UserErrorResponse();
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setDescription(exception.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		return new ResponseEntity(error,HttpStatus.NOT_FOUND);
//	}
}
