package com.emipaylelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.emipaylelo.model.Product;
import com.emipaylelo.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	ProductService productService;
	
	public Product addOrUpdateProduct(Product product) {
		// TODO Auto-generated method stub
		return productService.addOrUpdateProduct(product);
	}

	public Product viewProductByProductId(int productId) {
		// TODO Auto-generated method stub
		return productService.viewProductByProductId(productId);
	}
}
