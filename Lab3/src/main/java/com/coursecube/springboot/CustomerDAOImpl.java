package com.coursecube.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("custDAO")
public class CustomerDAOImpl implements CustomerDAO{
	@Autowired
	JdbcTemplate jdbcTemplatel;
	public void addCustomer(Customer cust) {
		String sql ="insert into customers value(?,?,?,?,?)";
		jdbcTemplatel.update(sql, cust.getCid(),cust.getCname(),cust.getEmail(),cust.getPhone(),cust.getCity());
	}
	public List<Customer> getAllCustomer() {
		String sql ="select * from customers";
		List<Customer>list = jdbcTemplatel.query(sql, new CustomerRowMapper());
		return list;
		
	}

}
