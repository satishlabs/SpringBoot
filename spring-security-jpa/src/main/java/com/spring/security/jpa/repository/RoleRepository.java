package com.spring.security.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.jpa.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
