package com.example.demo.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.errors.UserErrorResponse;
import com.example.demo.exceptions.UserNotFountException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> userDetailsExceptionHandler(UserNotFountException exception){
		UserErrorResponse error=new UserErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setDescription(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<UserErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
}
