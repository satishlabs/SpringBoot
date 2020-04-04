package com.coursecube.springboot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
