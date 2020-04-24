package com.spring.security.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.jpa.model.User;
import com.spring.security.jpa.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "User Restful Services", value = "UserController", description = "Controller for User")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	
	//getAllUsers method
	@ApiOperation(value = "Retrive list of users")
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<User> getAllUsers(){
		return userRepository.findAll();
		
	}
	
	@ApiOperation(value = "Create a new User")
	@PostMapping("/users/add")
	public User createUser(@ApiParam("User information for a new user to be created.") @RequestBody User user) {
		return userRepository.save(user);
	}
	
}
