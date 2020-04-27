package com.satish.msproducts.mapper;

import com.satish.msproducts.dto.ProductDTO;
import com.satish.msproducts.model.Product;

public class ProductMapper {
	
	//DtoToEntity() is the method used to map ProductDTO object to Product object.
	public static Product DtoToEntity(ProductDTO prd) {
		return new Product().setName(prd.getName())
				.setPrice(prd.getPrice());
		
	}
	
	//EntityToDto() converts Product object to ProductDTO object.
	public static ProductDTO EntityToDto(Product prd) {
		return new ProductDTO().setName(prd.getName())
				.setPrice(prd.getPrice());
		
	}
}
