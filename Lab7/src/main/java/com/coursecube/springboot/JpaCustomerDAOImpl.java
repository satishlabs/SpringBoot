package com.coursecube.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaCustomerDAOImpl implements CustomerDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void addCustomer(Customer cust) {
		entityManager.persist(cust);
		
	}
	@Override
	public List<Customer> getAllCustomers() {
		String jpasql ="from Customer cust";
		return entityManager.createQuery(jpasql,Customer.class).getResultList();
	}

}
