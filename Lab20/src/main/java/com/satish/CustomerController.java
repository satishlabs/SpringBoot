package com.satish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/mycustomer/{custId}", produces = "application/xml")
	public Customer getCustomerByCid(@PathVariable("custId")int custId) {
		System.out.println("CC- getCustomerByCid() - "+custId);
		Customer cust = customerService.getCustomerByCid(custId);
		return cust;
	}
	
	@GetMapping(value = "/mycustomers", produces = "application/xml")
	public Customers getAllCustomers() {
		System.out.println("CC - getAllCustomers() ");
		Customers customers = customerService.getAllCustomers();
		return customers;
	}
}
