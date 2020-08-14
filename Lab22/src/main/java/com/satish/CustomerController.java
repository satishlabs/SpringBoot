package com.satish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.satish.exception.CustomerIDNotFoundException;
import com.satish.exception.InvalidPhoneNumberException;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/mycustomer/custId/{custId}")
	public Customer getCustomerByCid(@PathVariable("custId")int custId) {
		System.out.println("CC- getCustomerByCid() - "+custId);
		Customer cust = null;
		try {
			cust = customerService.getCustomerByCid(custId);
		}catch (CustomerIDNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Id Not Found", ex);
		}
		return cust;
	}
	
	
	@GetMapping(value = "/mycustomer/phone/{phone}", produces = "application/json")
	public Customer getCustomerByPhone(@PathVariable("phone")long phone) {
		System.out.println("CC - getCustomerByPhone() - "+phone);
		Customer cust = null;
				try {
					cust =  customerService.getCustomerByPhone(phone);
				}catch (InvalidPhoneNumberException ex) {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Phone Number Not Found", ex); 
				}
		return cust;
	}
	
	@GetMapping(value = "/mycustomer/city/{city}", produces = "application/json")
	public List<Customer> getCustomerByCity(@PathVariable("city")String city){
		System.out.println("CC - getCustomerByCity() - "+city);
		List<Customer> custList = customerService.getCustomerByCity(city);
		return custList;
	}
}
