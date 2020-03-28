package com.coursecube.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("custDAO")

public class CustomerDAOImpl implements CustomerDAO{
	@Autowired
	JdbcTemplate jdbcTemp;
	
	public void addCustomer(Customer cust) {
		String sql = "insert into customers values(?,?,?,?,?)"; 
		jdbcTemp.update(sql, cust.getCid(), cust.getCname(), cust.getEmail(), cust.getPhone(), cust.getCity()); 
	}

	public List<Customer> getAllCustomer() {
		String sql = "select * from customers"; 
		List<Customer> list = jdbcTemp.query(sql, new CustomerRowMapper()); 
		return list; 
	}

}
