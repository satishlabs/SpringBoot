package com.satish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired  
	JdbcTemplate jdbcTemp; 
	
	@Override public void registerUser(User user) { 
		String sql="insert into myusers values(?,?,?,?,?,?,?)"; 
		jdbcTemp.update(sql,user.getUsername(),user.getPassword(),user.getFirstname(),user.getLastname(),user.getEmail(),user.getPhone(),user.getActive()); 
		
	} 
}
