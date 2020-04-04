package com.coursecube.springboot;

import java.math.BigInteger;
import java.util.List;

public interface CustomerDAO {
	public void addCustomer(Customer cust);
	public void updateCustomer(Customer cust);
	public void deleteCustomer(int cid);
	public Customer getCustomerById(int cid);
	
	public List<Customer> getAllCustomers();
	public List<Customer> getCustomerByCity(String city);
	public List<Customer> getCustomerByEmail(String email);
	public List<Customer> getCustomerByEmailAndPhone(String email,long phone);
	public List<Customer> getCustomerByEmailOrPhone(String email,long phone);
	
	public BigInteger getCustomerCount();
	public BigInteger getCustomerCountByCity(String city);
	public String getCityByEmail(String email);
	public long getPhoneByEmail(String email);
	public int getCidByPhone(long phone);
}
