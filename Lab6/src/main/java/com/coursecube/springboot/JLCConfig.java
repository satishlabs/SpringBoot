package com.coursecube.springboot;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class JLCConfig {

	@Bean(name="jlcDataSource")
	public DataSource dataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jlcdb");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
		
	}
	
	@Bean(name="jlcSessionFactory") 
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(dataSource);
		
		Properties properties = new Properties();
		properties.put("hibernate.show.sql","true");
		properties.put("hibernate.format.sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
		
		lsfb.setHibernateProperties(properties);
		lsfb.setPackagesToScan("com.coursecube.springboot");
		return lsfb;
		
	}
	
	@Bean(name="jlcHibernateTemplate")
	public HibernateTemplate hibernateTemplate(SessionFactory sf){
		return new HibernateTemplate(sf);
		
	}
	
	@Bean(name="jlcHibernateTransactionManager")
	public PlatformTransactionManager transactionManager(SessionFactory sf){
		return new HibernateTransactionManager(sf);
		
	}
	
}
