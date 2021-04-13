package com.emipaylelo.dao;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.Product;

@Component
public interface ProductInt {

	public Product addOrUpdateProduct(Product product);
	
	public Product viewProductByProductId(int productId);
	
	
}
