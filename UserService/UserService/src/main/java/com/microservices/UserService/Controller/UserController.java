package com.microservices.UserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.UserService.Impl.UserServiceImpl;
import com.microservices.UserService.Model.User;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	//create
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		User user1 = userServiceImpl.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	//getall user
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> alluser = userServiceImpl.getAllUser();
		return ResponseEntity.ok(alluser);
	}
	
	//get single user
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id){
		User user = userServiceImpl.getUserById(id);
		return ResponseEntity.ok(user);
	}

}
