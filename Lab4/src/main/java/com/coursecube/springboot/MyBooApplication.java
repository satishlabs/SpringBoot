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
public class MyBooApplication implements CommandLineRunner
{	
	private static final Logger log = LoggerFactory.getLogger(MyBooApplication.class); 
	
	@Autowired
	CustomerDAO cdao;
	
    public static void main( String[] args )
    {
      SpringApplication.run(MyBooApplication.class, args);
    }

	public void run(String... args) throws Exception {

    	log.info("My Boot Application...Starts");
		log.debug("My Boot Application...Starts");
		log.info("--------------------------------");
		//1. add customer
		Customer cust1 = new Customer(100, "manish", "m@jlc.com", 87544, "Blore");
		cdao.addCustomer(cust1);
		
		//2. get All Custmers
		System.out.println("All Customer");
		List<Customer> custList =cdao.getAllCustomer();
		custList.forEach(cust->System.out.println(cust));
		
		log.info("---------------------------------------");
		log.info("My Boot Application...Ends");
		log.debug("My Boot Application...Ends");
	}
}
