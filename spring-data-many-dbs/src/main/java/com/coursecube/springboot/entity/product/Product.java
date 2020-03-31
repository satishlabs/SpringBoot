package com.coursecube.springboot.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pid")
	private int pid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	public Product() {}

	public Product(String name, double price) {

		this.name = name;
		this.price = price;
	}
	
	
}
