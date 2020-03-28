package com.coursecube.springboot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer>{

	public Customer mapRow(ResultSet rs, int rn) throws SQLException {
		
		Customer cust=new Customer(); 
		cust.setCid(rs.getInt(1)); 
		cust.setCname(rs.getString(2)); 
		cust.setEmail(rs.getString(3)); 
		cust.setPhone(rs.getLong(4)); 
		cust.setCity(rs.getString(5)); 
		return cust; 
	}

}
