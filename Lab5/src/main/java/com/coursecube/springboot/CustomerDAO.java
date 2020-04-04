package com.coursecube.springboot;

import java.util.List;

public interface CustomerDAO {
	public void addCustoemr(Customer cut);
	public List<Customer> getAllCustomer();
}
