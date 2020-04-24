package com.spring.security.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.jpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsername(String username);

}
