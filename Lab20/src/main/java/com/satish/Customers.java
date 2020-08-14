package com.satish;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customers {
	List<Customer> mycustomer;

	public Customers() {}
	public Customers(List<Customer> mycustomer) {
		super();
		this.mycustomer = mycustomer;
	}
	public List<Customer> getMycustomer() {
		return mycustomer;
	}
	public void setMycustomer(List<Customer> mycustomer) {
		this.mycustomer = mycustomer;
	} 
}
