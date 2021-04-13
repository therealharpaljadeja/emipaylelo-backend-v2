package com.emipaylelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emipaylelo.model.Product;
@Repository
public class ProductDao implements ProductInt{
	@PersistenceContext
	EntityManager em;
	
	
	public ProductDao(){
	
	}
	@Transactional
	public Product addOrUpdateProduct(Product product){
		Product productPersisted = em.merge(product);
		return productPersisted;
	}
	@Transactional
	public Product viewProductByProductId(int productId){
		return em.find(Product.class, productId);
	}
}
