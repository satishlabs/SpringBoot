package com.satish.dao;

import java.util.List;

import com.satish.entity.Book;

public interface BookDAO {
	public List<Book> getAllBooks();
	public Book getBookById(Integer bid);
	public void addBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(Integer bid);
}
