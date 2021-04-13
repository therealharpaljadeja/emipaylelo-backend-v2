package com.emipaylelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.emipaylelo.dao.ProductInt;
import com.emipaylelo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductInt productInt;
	
	public Product addOrUpdateProduct(Product product) {
		// TODO Auto-generated method stub
		return productInt.addOrUpdateProduct(product);
	}

	public Product viewProductByProductId(int productId) {
		// TODO Auto-generated method stub
		return productInt.viewProductByProductId(productId);
	}

}
