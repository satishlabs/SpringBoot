package com.satish.msproducts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satish.msproducts.model.Product;
import com.satish.msproducts.repository.ProductRepository;

@Service
public class ProductService implements Iproduct{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(int id) {
		return productRepository.findById(id);
	}

	@Override
	public Product save(Product prodcut) {
		return productRepository.save(prodcut);
	}

	@Override
	public void delete(int id) {
		productRepository.deleteById(id);
	}
	
	

}
