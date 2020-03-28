package com.coursecube.springboot;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer, Integer>{
	public List<Customer> findCustomerByCname(String cname);
	public List<Customer> findCustomerByEmail(String email);
	public List<Customer> findByPhone(int phone);
	public List<Customer> getCustomerByEmailAndPhone(String email,int phone);
	public List<Customer> getCustomerByEmailOrPhone(String email,int phone);
}
