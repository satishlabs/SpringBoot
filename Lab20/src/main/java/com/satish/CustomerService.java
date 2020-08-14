package com.satish;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	public Customer getCustomerByCid(int custId) {
		Customer cust = new Customer(custId, "Satish", "satish@gmail", 767613, "Ranchi");
		return cust;
	}
	
	public Customers getAllCustomers(){
		List<Customer> custList = new ArrayList<>();
		
		custList.add(new Customer(101, "Satish", "satish@gmail", 7042, "Ranchi"));
		custList.add(new Customer(102, "Rohit", "rohit@gmail", 10987, "Mumbai"));
		custList.add(new Customer(103, "Dhoni", "dhoni@gmail", 7042, "Delhi"));
		custList.add(new Customer(104, "Virat", "virat@gmail", 12466, "Delhi"));
		custList.add(new Customer(105, "Dravid", "dravid@gmail", 80976, "Bangalore"));
		
		Customers customers = new Customers(custList);
		
		return customers;
	}
}
