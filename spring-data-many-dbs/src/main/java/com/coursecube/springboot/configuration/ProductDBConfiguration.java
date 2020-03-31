package com.coursecube.springboot.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.coursecube.springboot.entity.product.Product;
import com.coursecube.springboot.repository.product.ProductRepository;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = ProductRepository.class,entityManagerFactoryRef = "productDBEmFactory",transactionManagerRef = "productDSTransactionManager")
public class ProductDBConfiguration {
	
	@Bean
	@ConfigurationProperties("spring.datasource2")
	public DataSourceProperties productDSProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	public DataSource productDS(@Qualifier("productDSProperties") DataSourceProperties productDSProperties) {
		return productDSProperties().initializeDataSourceBuilder().build();
		
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean productDBEmFactory(@Qualifier("productDS") DataSource productDS,EntityManagerFactoryBuilder builder) {
		return builder.dataSource(productDS).packages(Product.class).build();	
	}
	
	@Bean
	public PlatformTransactionManager productDSTransactionManager(EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}

}
