package com.satish.msproducts.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.satish.msproducts.dto.ProductDTO;
import com.satish.msproducts.exception.ProductNotFoundException;
import com.satish.msproducts.mapper.ProductMapper;
import com.satish.msproducts.model.Product;
import com.satish.msproducts.service.ProductService;


@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/products")
	List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping(value = "/products/{id}")
	ResponseEntity<Product> getById(@PathVariable("id")@Min(1)int id){
		Product prd = productService.findById(id)
						.orElseThrow(()->new ProductNotFoundException("No Product with Id: "+id));
		return ResponseEntity.ok().body(prd);
		
	}
	
	@PostMapping(value = "/products")
	ResponseEntity<?> createProducts(@Valid @RequestBody ProductDTO  prodDto){
		Product prd = ProductMapper.DtoToEntity(prodDto);
		
		Product addProd = productService.save(prd);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(addProd.getId())
						.toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping(value = "/products/{id}")
	ResponseEntity<Product> updateProduct(@PathVariable("id") @Min(1) int id, @Valid @RequestBody ProductDTO pordDto){
		Product prd = productService.findById(id)
						.orElseThrow(()->new ProductNotFoundException("No Product with Id: "+id));
		
		Product newProd = ProductMapper.DtoToEntity(pordDto);
		newProd.setId(prd.getId());
		productService.save(newProd);
		
		return ResponseEntity.ok().body(newProd);
		
	}
	
	@DeleteMapping(value = "/products/{id}")
	ResponseEntity deleteProduct(@PathVariable("id") @Min(1) int id) {
		Product prod = productService.findById(id)
						.orElseThrow(()->new ProductNotFoundException("No Product with Id: "+id));
		productService.delete(prod.getId());
		return ResponseEntity.ok().body("Prodcut with Id: "+id+" deleted with success!");
		
	}
}
