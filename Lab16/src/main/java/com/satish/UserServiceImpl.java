package com.satish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void registerUser(User user) {
		System.out.println(user.getPassword()); 
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); 
		System.out.println(user.getPassword()); 
		user.setActive(1); 
		userDAO.registerUser(user); 
	} 
} 