package com.microservices.UserService.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException() {
		super("Resource not ound on server!!!");
	}
	
	public ResourceNotFoundException(String message){
		super(message);
	}
}
