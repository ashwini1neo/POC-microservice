package com.neosoft.user.exception;

public class UserCreationException extends Exception{
	
	private String message;
	
	public UserCreationException() {
	}

	public UserCreationException(String message) {
		this.message = message;
	}
	
	

}
