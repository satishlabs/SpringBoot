package com.satish.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.satish.entity.Customer;

import io.swagger.annotations.ApiOperation;

@RestController
public class CustomerController {

	@ApiOperation(value = " get the Customer By Cid",response = double.class,
			notes = "Gives Customer Full Information By CID" )
	@GetMapping(value = "/mycustomer/custId/{custId}", produces = "application/xml")
	public Customer getCustomerByCid(@PathVariable("custId") int custId) {
		System.out.println("CC-getCustomerByCid() - " + custId);
		Customer cust = new Customer(custId, "Srinivas", "sri@jlc.com", 12345, "Blore");
		return cust;
	} 

	@ApiOperation(value = " get the Customer By Phone",response = Customer.class,
			notes = "Gives Customer Full Information By Phone" )
	@GetMapping(value = "/mycustomer/phone/{phone}", produces = "application/xml")
	public Customer getCustomerByPhone(@PathVariable("phone") long phone) {
		System.out.println("CC-getCustomerByPhone() - " + phone);
		Customer cust = new Customer(109, "Dande", "dande@jlc.com", phone, "Blore");
		return cust;
	}

	@ApiOperation(value = " get the Customer By City",response = List.class,
			notes = "Gives Customers Full Information By City" )
	@GetMapping(value = "/mycustomer/city/{city}", produces = "application/json")
	public List<Customer> getCustomersByCity(@PathVariable("city") String city) {
		System.out.println("CC-getCustomersByCity() - " + city);
		List<Customer> custList = new ArrayList<>();
		custList.add(new Customer(101, "Sri", "sri@jlc.com", 111, city));
		custList.add(new Customer(102, "Vas", "vas@jlc.com", 222, city));
		custList.add(new Customer(103, "SD", "sd@jlc.com", 333, city));
		custList.add(new Customer(104, "DS", "ds@jlc.com", 444, city));
		custList.add(new Customer(105, "Dande", "dande@jlc.com", 555, city));
		custList.add(new Customer(106, "Dande", "dande@jlc.com", 555, city));
		return custList;
	} 
}
