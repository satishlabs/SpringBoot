package com.coursecube.springboot.repository.product;

import org.springframework.data.repository.CrudRepository;

import com.coursecube.springboot.entity.product.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
