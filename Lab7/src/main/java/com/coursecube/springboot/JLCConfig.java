package com.coursecube.springboot;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication(scanBasePackages="com.coursecube.springboot")
public class JLCConfig {
	
	@Bean(name ="jlcVenderAdaptor")
	public JpaVendorAdapter hiJpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		return adapter;
	}
	
	@Bean(name="jlcEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource ds,JpaVendorAdapter jpaVendorAdapter){
		LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
		emFactory.setDataSource(ds);
		emFactory.setJpaVendorAdapter(jpaVendorAdapter);
		emFactory.setPackagesToScan("com.coursecube.springboot");
		return emFactory;	
	}
	
	@Bean(name="jlcTransactionManager")
	public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean){
		 EntityManagerFactory factory = entityManagerFactoryBean.getObject();
		return new JpaTransactionManager(factory);
		
	}
}
