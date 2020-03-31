package com.coursecube.springboot;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coursecube.springboot.entity.product.Product;
import com.coursecube.springboot.entity.user.User;
import com.coursecube.springboot.repository.product.ProductRepository;
import com.coursecube.springboot.repository.user.UserRepository;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SpringDataManyDbsApplication 
{
    public static void main( String[] args )
    {
      SpringApplication.run(SpringDataManyDbsApplication.class, args);
    }
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @PostConstruct
    void init() {
    	User user = new User("Satish", "Prasad");
    	userRepository.save(user);
    	
    	Product product = new Product("Mobile", 23);
    	productRepository.save(product);
    }
}
