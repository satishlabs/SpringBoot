package com.coursecube.springboot;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages="com.coursecube.springboot")
public class MyBootApplication implements CommandLineRunner 
{	
	Logger log = LoggerFactory.getLogger(MyBootApplication.class); 
	
	@Autowired
	CustomerDAO customerDAO;
	
    public static void main( String[] args )
    {
       SpringApplication.run(MyBootApplication.class, args);
    }

	public void run(String... args) throws Exception {
		log.info("My Boot Application...Starts---Lab10"); 
		log.info("-------------------------------------------------"); 
		
		//1.findCustomerByCname 
		List<Customer> list = customerDAO.findCustomerByCname("Ms");
		list.forEach(cust->System.out.println(cust));
		
		//2. findCustomerByEmail
		 list = customerDAO.findCustomerByEmail("rohit@sap");
		 list.forEach(cust->System.out.println(cust));
		
		//3. findByPhone
		 list = customerDAO.findByPhone(12345);
		 list.forEach(cust->System.out.println(cust));
		 
		//4.getCustomerByEmailAndPhone 
		 list = customerDAO.getCustomerByEmailAndPhone("sachin@sap", 12345);
		 list.forEach(cust->System.out.println(cust));
		 
		//4.getCustomerByEmailOrPhone 
		 list = customerDAO.getCustomerByEmailOrPhone("sachin@sap", 123);
		 list.forEach(cust->System.out.println(cust));
		
		log.info("-------------------------------------------------"); 
		log.info("My Boot Application...Ends---Lab10"); 
	}
}
