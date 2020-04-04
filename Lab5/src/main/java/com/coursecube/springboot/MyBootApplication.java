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
{	private static final Logger log = LoggerFactory.getLogger(MyBootApplication.class); 
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
		
		//1. Add Customer
		Customer cust1 = new Customer(123, "Kausik", "Kapil@sap.com", 8765, "JAP");
		cdao.addCustoemr(cust1);
		
		//2. get All custoemr
		System.out.println("All Customer");
		List<Customer> cList = cdao.getAllCustomer();
		cList.forEach(cust->System.out.println(cust));
		
		log.info("---------------------------------------");
		log.info("My Boot Application...Ends");
		log.debug("My Boot Application...Ends");
	}
}
