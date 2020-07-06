package com.satish.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.satish.dao.BookDAO;
import com.satish.entity.Book;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO{

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Book> getAllBooks() {
		System.out.println("----BookDAOImpl -- getAllBooks()------");
		String jpaal = "from Book book";
		List<Book> list = entityManager.createQuery(jpaal).getResultList();
		return list;
	}

	@Override
	public Book getBookById(Integer bid) {
		System.out.println("-----BookDAOImpl--getBookById()---------"); 
		return entityManager.getReference(Book.class, bid);
	}

	@Override
	public void addBook(Book book) {
		System.out.println("-----BookDAOImpl--addBook()---------"); 
		entityManager.persist(book);
	}

	@Override
	public void updateBook(Book book) {
		System.out.println("-----BookDAOImpl--updateBook()---------"); 
		entityManager.merge(book);

	}

	@Override
	public void deleteBook(Integer bid) {
		System.out.println("-----BookDAOImpl--deleteBook()---------"); 
		Book book = entityManager.getReference(Book.class, bid);
		entityManager.remove(book);
	}

}
