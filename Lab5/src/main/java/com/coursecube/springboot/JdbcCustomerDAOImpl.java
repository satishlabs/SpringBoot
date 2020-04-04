package com.coursecube.springboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("custDAO")
public class JdbcCustomerDAOImpl implements CustomerDAO{
	@Autowired
	NamedParameterJdbcTemplate npjtemp;
	
	public void addCustoemr(Customer cust) {
		String sql ="insert into customers values(:mycid,:myname,:myemail,:myphone,:mycity)";
		Map<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("mycid", cust.getCid());
		hmap.put("myname", cust.getCname());
		hmap.put("myemail", cust.getEmail());
		hmap.put("myphone", cust.getPhone());
		hmap.put("mycity", cust.getCity());
		
		npjtemp.update(sql, hmap);
	}

	public List<Customer> getAllCustomer() {
		String sql = "select * from customers";
		Map<String, Object>hmap = new HashMap<String, Object>();
		return npjtemp.query(sql, hmap, new CustomerRowMapper());
	}

}
