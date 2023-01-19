package com.microservices.UserService.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.UserService.Model.User;

public interface UserService {
	
	//save user
	User saveUser(User user);
	
	//getall users
	List<User> getAllUser();
	
	//get single user of given id
	User getUserById(String id);
}
