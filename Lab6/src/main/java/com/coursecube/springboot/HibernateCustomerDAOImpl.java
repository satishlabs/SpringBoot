package com.coursecube.springboot;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class HibernateCustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Override
	public void addCustomer(Customer cust) {
		hibernateTemplate.save(cust);
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		return hibernateTemplate.loadAll(Customer.class);
	}

}
