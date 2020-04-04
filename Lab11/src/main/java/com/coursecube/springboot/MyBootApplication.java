package com.coursecube.springboot;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

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
		log.info("My Boot Application...Starts---Lab11"); 
		log.info("-------------------------------------------------"); 
		 
		System.out.println("============getCustomers===========");
		List<Customer> list = customerDAO.getCustomers("Satish");
		list.forEach(cust->System.out.println(cust));
		
		System.out.println("=============cname and Email ============");
		List<Customer> list1 = customerDAO.getCustomers("Delhi", "kohli@sap");
		list1.forEach(cust->System.out.println(cust));
		
		
		System.out.println("===========getCustomerByCity==============");
		List<Customer> list2 = customerDAO.getCustomersByCity("Ranchi");
		list2.forEach(cust->System.out.println(cust));
		
		System.out.println("=================getCustomercity======================");
		//Sort sort = new Sort(Direction.DESC, "cname"); 
		Sort sort = Sort.by(Sort.Direction.DESC,"cname");
		List<Customer> list3 = customerDAO.findCustomerByCity("Delhi",sort);
		list3.forEach(cust->System.out.println(cust));
		
		
		System.out.println("===================getCustomerCity with Pageable===================");
		Pageable pageable = PageRequest.of(0, 2);
		List<Customer> list4 = customerDAO.readCustomersByCity("Delhi", pageable);
		list4.forEach(cust->System.out.println(cust));
		
		System.out.println("==================NativeQuery==================");
		List<Customer> list5 = customerDAO.findCustomersByPhone(12345);
		list5.forEach(cust->System.out.println(cust));
		
		log.info("------------------------------------"); 
		log.info("My Boot Application...Ends---Lab11"); 
	}
}
