package com.emipaylelo.service;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.Product;
@Component
public interface ProductService {

    public Product addOrUpdateProduct(Product product);
	
	public Product viewProductByProductId(int productId);
}
