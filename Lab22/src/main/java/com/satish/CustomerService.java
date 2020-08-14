package com.satish;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.satish.exception.CityNotFoundException;
import com.satish.exception.CustomerIDNotFoundException;
import com.satish.exception.InvalidPhoneNumberException;

@Service
public class CustomerService {

	public Customer getCustomerByCid(int custId) {
		Customer cust = null;
		if(custId >= 100) {
			cust = new Customer(custId, "Satish", "satish@gmail", 767613, "Ranchi");
		}else {
			throw new CustomerIDNotFoundException();
		}
		return cust;
	}
	
	
	public Customer getCustomerByPhone(long phone) {
		Customer cust = null;
		if(phone >= 50000) {
			cust = new Customer(109, "Dande", "dande@gmail", 87867, "Delhi");
		}else {
			throw new InvalidPhoneNumberException();
		}
		return cust;
	}
	
	public List<Customer> getCustomerByCity(String city){
		List<Customer> custList = new ArrayList<>();
		if(city.equals("Ranchi")) {
			custList.add(new Customer(101, "Satish", "satish@gmail", 7042, "Ranchi"));
			custList.add(new Customer(102, "Rohit", "rohit@gmail", 10987, "Mumbai"));
			custList.add(new Customer(103, "Dhoni", "dhoni@gmail", 7042, "Delhi"));
			custList.add(new Customer(104, "Virat", "virat@gmail", 12466, "Delhi"));
			custList.add(new Customer(105, "Dravid", "dravid@gmail", 80976, "Bangalore"));
		}else {
			throw new CityNotFoundException();
		}
		return custList;
	}
}
