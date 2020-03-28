package com.coursecube.springboot;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
@ComponentScan(basePackages="com.coursecube.springboot")
@Configuration
public class JLCConfig {
	@Bean
	public DataSource dataSource(){
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/jlcdb");
		bds.setUsername("root");
		bds.setPassword("root");
		bds.setInitialSize(10);
		bds.setMaxActive(15);
		return bds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds){
		return new JdbcTemplate(ds);
	}
}
