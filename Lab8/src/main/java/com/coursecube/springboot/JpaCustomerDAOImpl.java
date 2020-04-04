package com.coursecube.springboot;

import java.math.BigInteger;
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

	public void updateCustomer(Customer cust) {
		entityManager.merge(cust);
		
	}

	public void deleteCustomer(int cid) {
		Customer cust = entityManager.getReference(Customer.class, cid);
		entityManager.remove(cust);
	}

	public Customer getCustomerById(int cid) {
		return entityManager.find(Customer.class, cid);
	}

	public List<Customer> getAllCustomers() {
		String jpasql = "from Customer cust";
		return entityManager.createQuery(jpasql, Customer.class).getResultList();
	}

	public List<Customer> getCustomerByCity(String city) {
		String jpasql = "from Customer where city:?1";
		return entityManager.createQuery(jpasql, Customer.class)
				.setParameter(1, city)
				.getResultList();
	}

	public List<Customer> getCustomerByEmail(String email) {
		String jpasql ="from Customer where email=?";
		return entityManager.createQuery(jpasql, Customer.class)
				.setParameter(1, email)
				.getResultList();
	}

	public List<Customer> getCustomerByEmailAndPhone(String email, long phone) {
		String jpasql ="from customer cust where email=?1 and phone=?2";
		return entityManager.createQuery(jpasql, Customer.class)
				.setParameter(1, email)
				.setParameter(2, phone)
				.getResultList();
	}

	public List<Customer> getCustomerByEmailOrPhone(String email, long phone) {
		String jpasql ="from Customer cust email=1 or phone=2";
		return entityManager.createQuery(jpasql, Customer.class)
				.setParameter(1, email)
				.setParameter(2, phone)
				.getResultList();
	}

	public BigInteger getCustomerCount() {
		String sql = "select count(*) from Customer";
		return (BigInteger) entityManager.createNativeQuery(sql).getSingleResult();
	}

	public BigInteger getCustomerCountByCity(String city) {
		String sql ="select count(*) from customer where city=?";
		return (BigInteger) entityManager.createNamedQuery(sql)
				.setParameter(1, city)
				.getSingleResult();
	}

	public String getCityByEmail(String email) {
		String sql ="select city from customer where email=?";
		return (String) entityManager.createNamedQuery(sql)
				.setParameter(1, email)
				.getSingleResult();
	}

	public long getPhoneByEmail(String email) {
		String sql="select phone from customer where email=?";
		return (Long) entityManager.createNamedQuery(sql)
				.setParameter(1, email)
				.getSingleResult();
	}

	public int getCidByPhone(long phone) {
		String sql="select * from cid from Customer where phone=?";
		return (Integer) entityManager.createNamedQuery(sql)
				.setParameter(1, phone)
				.getSingleResult();
	}

}
