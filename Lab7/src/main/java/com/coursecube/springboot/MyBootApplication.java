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
	private static final Logger log = LoggerFactory.getLogger(MyBootApplication.class); 
	 @Autowired
	 CustomerDAO cdao;
    public static void main( String[] args )
    {
       SpringApplication.run(MyBootApplication.class, args);
    }

	public void run(String... args) throws Exception {
		log.info("My Boot Application...Starts - Lab7");
		log.debug("My Boot Application...Starts - Lab7");
		log.info("------------------------------------"); 

		
		//1. addCustomer
		Customer cust2 = new Customer("kk1", "kk1@sap.com", 87365, "Patna");
		cdao.addCustomer(cust2);
		
		// 2. getAllCustomers
		System.out.println("getAllCustomers");
		List<Customer> list=cdao.getAllCustomers();
		list.forEach( cust -> System.out.println(cust) ); 
		
		log.info("------------------------------------");
		log.info("My Boot Application...Ends - Lab7");
		log.debug("My Boot Application...Ends - Lab7"); 

	}
}
