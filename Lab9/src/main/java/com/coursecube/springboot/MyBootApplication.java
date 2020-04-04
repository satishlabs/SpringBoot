package com.coursecube.springboot;

import java.util.ArrayList;
import java.util.Date;
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
	public static final Logger log = LoggerFactory.getLogger(MyBootApplication.class); 
	
	@Autowired
	CustomerDAO customerDAO;
	
    public static void main( String[] args )
    {
        SpringApplication.run(MyBootApplication.class, args);
    }

	public void run(String... args) throws Exception {
		log.info("My Boot Application...Starts---Lab9"); 
		log.info("-------------------------------------------------"); 
		//1. save
		Customer cust=null;
		cust = new Customer("Ms", "ms@sap", 12345, "Ranchi", new Date(), new Date(), "ms");
		cust = new Customer("Kapil", "kapil@sap", 12345, "Delhi", new Date(), new Date(), "user");
		cust = new Customer("Sachin", "sachin@sap", 12345, "Mumbai", new Date(), new Date(), "user");
		cust = new Customer("Kohli", "kohli@sap", 12345, "Delhi", new Date(), new Date(), "user");
		cust = new Customer("Jdeja", "jaddu@sap", 12345, "Jaipur", new Date(), new Date(), "admin");
		cust = new Customer("Rohit", "rohit@sap", 12345, "Mumbai", new Date(), new Date(), "user");
		customerDAO.save(cust);
		
		//2. saveAndFlush  == Saves an entity and flushes changes instantly.
		//cust = new Customer("Sehwag", "sw@sap", 12345, "Delhi", new Date(), new Date(), "user");
		//customerDAO.saveAndFlush(cust);
		
		//3.saveAll() 
	/*	Customer cust1 = new Customer("Shami", "shami@sap", 12345, "Noida", new Date(), new Date(), "user");
		Customer cust2 = new Customer("Rahul", "rahul@sap", 12345, "Bangalore", new Date(), new Date(), "user");
		List<Customer> list = new ArrayList<Customer>();
		list.add(cust1);
		list.add(cust2);
		customerDAO.saveAll(list);
		*/
		//4.findById 
		//Customer cust3 = customerDAO.findById(3).get();
		//System.out.println("Cust findById()===: "+cust3);
		
		// 5. findAll 
		//List<Customer> list1 = customerDAO.findAll();
		//System.out.println("findAll() @@@ "+list1);
		
		//6.findAllById(list)
		/*List<Integer> idList = new ArrayList<Integer>();
		idList.add(2);
		idList.add(7);
		idList.add(5);
		idList.add(11);
		List<Customer> cList = customerDAO.findAllById(idList);
		System.out.println("CList== Customers()=== "+cList);*/
		
		// 7. findAll(Sort) 
		/*System.out.println("findAll(Sort)");
		List<Customer> list2 = customerDAO.findAll(Sort.by(Order.desc("cid")));
		System.out.println("List2 :"+ list2);*/
		
		/*System.out.println("findAll(Sort)"); 
		List<Customer> list3 = customerDAO.findAll(Sort.by(Order.asc("cname")));
		System.out.println("List3 :"+list3);*/
		
		//8.getOne()
		/*
		Customer cust1 = customerDAO.getOne(2);
		System.out.println("Cust1 getOne() "+cust1);*/
		
		//9.deleteById(Id) 
		//customerDAO.deleteById(7);
		
		//10.delete(entity)
		/*cust = new Customer("Ms", "ms@sap", 12345, "Ranchi", new Date(), new Date(), "ms");
		customerDAO.delete(cust);*/
		
		//11.deleteAll(list); 
		/*Customer cust3 = customerDAO.findById(15).get();
		System.out.println("Cust3: %%% "+cust3);
		Customer cust4 = customerDAO.findById(16).get();
		List<Customer> cList2 = new ArrayList<Customer>();
		cList2.add(cust3);
		cList2.add(cust4);
		customerDAO.deleteAll(cList2);*/
		
		//12.deleteAll() 
		//cdao.deleteAll(); 
		
		//13.existsById(ID id) 
		/*boolean b = customerDAO.existsById(15);
		System.out.println("$$$$$$$=== TRUE/FALSE===$$$$$ "+b);*/
		
		//14.count() 
		/*long count = customerDAO.count();
		System.out.println("$$$$===== COUNT =====$$$$ "+ count);*/
		
		
		//15.flush() 
		//customerDAO.flush();
		
		log.info("-------------------------------------------------"); 
		log.info("My Boot Application...Ends---Lab9"); 
		
	}
}
