package com.satish.msproducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satish.msproducts.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
