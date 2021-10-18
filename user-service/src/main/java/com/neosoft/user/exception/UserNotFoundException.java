package com.neosoft.user.exception;

public class UserNotFoundException extends Exception{
	
	private String message;

	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	

}
