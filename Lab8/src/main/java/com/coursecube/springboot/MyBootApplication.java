package com.coursecube.springboot;

import java.math.BigInteger;
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
		log.info("My Boot Application...Starts - Lab8"); 
		log.info("------------------------------------"); 
		 
		
		//1. addCustoemr
		//Customer cust1 = new Customer("Satish", "prasad@sap", 12345, "Ranchi");
		//cdao.addCustomer(cust1);
		
		//2. update Custoemr
		//Customer cust2 = new Customer(2, "MSDhoni", "ms@sap", 98090, "India");
		//cdao.updateCustomer(cust2);
		
		//3. delete Customer
		//cdao.deleteCustomer(3);
		
		//4. getCustomerByCid
		//Customer cust3 = cdao.getCustomerById(6);
		//System.out.println("##########: "+cust3+" @@@@@@@@@@@");
		
		//5. getAllCustomers
		List<Customer> custList = cdao.getAllCustomers();
		custList.forEach(cust->System.out.println(cust));
		 
		//6. getCustomerByCity
		//custList= cdao.getCustomerByCity("Ranchi");
		//custList.forEach(cust->System.out.println(cust));
		
		//7. get CustomerByEmail
		custList = cdao.getCustomerByEmail("ms@sap");
		custList.forEach(cust->System.out.println(cust));
		
		//8.getCustomersByEmailAndPhone 
		custList=cdao.getCustomerByEmailAndPhone("ms@sap",98090);
		custList.forEach(cust -> System.out.println(cust)); 
		 
		//9.getCustomersByEmailOrPhone 
		custList=cdao.getCustomerByEmailOrPhone("ms@sap",98090);
		custList.forEach(cust -> System.out.println(cust)); 
		 
		//10.getCustomerCount 
		BigInteger big = cdao.getCustomerCount(); 
		System.out.println("All Count : " + big.intValue()); 
		 
		//11.getCustomerCountByCity 
		big = cdao.getCustomerCountByCity("Hyd"); 
		System.out.println(" Count : " + big.intValue()); 
		
		//12.getCityByEmail 
		String city = cdao.getCityByEmail("vas@jlc"); 
		System.out.println(city); 
		 
		//13.getPhoneByEmail 
		long phone = cdao.getPhoneByEmail("vas@jlc"); 
		System.out.println(phone); 
		 
		//14.getCidByPhone 
		int cid = cdao.getCidByPhone(123); 
		System.out.println(cid); 
		
		log.info("------------------------------------"); 
		log.info("My Boot Application...Ends  - Lab8"); 
	}
}
