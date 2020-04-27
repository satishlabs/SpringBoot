package com.satish.msproducts.service;

import java.util.List;
import java.util.Optional;

import com.satish.msproducts.model.Product;

public interface Iproduct {
	List<Product> getAllProducts();
	Optional<Product> findById(int id);
	Product save(Product prodcut);
	void delete(int id);
}
