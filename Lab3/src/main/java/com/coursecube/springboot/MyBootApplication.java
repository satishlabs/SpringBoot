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
		log.info("My Boot Application...Starts");
		log.debug("My Boot Application...Starts");
		log.info("--------------------------------");
		
		//1 Add Customer
		Customer cust1 = new Customer(93, "Satish", "sati@sap.com", 89765, "Ranchi");
		cdao.addCustomer(cust1);
		
		//2. get All Customers
		System.out.println("getAllCustomers");
		List<Customer> cList = cdao.getAllCustomer();
		cList.forEach(cust->System.out.println(cust));
		
		log.info("---------------------------------------");
		log.info("My Boot Application...Ends");
		log.debug("My Boot Application...Ends");
	}
}
