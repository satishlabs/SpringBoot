package com.satish.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import lombok.Getter;

import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity
@Table(name = "mybooks")
public class Book {
	@Id
	@Column(name = "bid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bid;
	
	@Column(name = "bname")
	@NotEmpty(message = "Book Name is Required")
	@Size(min = 5, max = 20, message = "Name length must be between 5 and 20")
	private String bname;
	
	@Column(name = "author")
	@NotEmpty(message = "Author is Required")
	@Size(min = 3, max = 10, message = "Name length must be between 3 and 10")
	private String author;
	
	@Column(name = "price")
	@NotEmpty(message = "Price is  Required")
	@Min(value = 500, message = "Price must be min : 500")
	@Max(value = 1500, message = "Price must be max : 1500")
	private BigDecimal price;
	
	@Column(name="category")   
	@NotEmpty(message = "Category is  Required")  
	private String category; 
	
	@Column(name = "pub")
	@NotEmpty(message = "Pub is  Required")
	private String pub;
	
	public Book() {}

	public Book(Integer bid,
			@NotEmpty(message = "Book Name is Required") @Size(min = 5, max = 20, message = "Name length must be between 5 and 20") String bname,
			@NotEmpty(message = "Author is Required") @Size(min = 3, max = 10, message = "Name length must be between 3 and 10") String author,
			@NotEmpty(message = "Price is  Required") @Min(value = 500, message = "Price must be min : 500") @Max(value = 1500, message = "Price must be max : 1500") BigDecimal price,
			@NotEmpty(message = "Category is  Required") String category,
			@NotEmpty(message = "Pub is  Required") String pub) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.price = price;
		this.category = category;
		this.pub = pub;
	}

	
	
}
