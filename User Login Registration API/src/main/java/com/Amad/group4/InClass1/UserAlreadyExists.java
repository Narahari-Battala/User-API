package com.Amad.group4.InClass1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//this exception message is thrown when user already exists.
@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExists extends RuntimeException{

	public UserAlreadyExists(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
