package com.emipaylelo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.emipaylelo.controller.CardTypeController;
import com.emipaylelo.controller.ProductController;
import com.emipaylelo.dao.ProductDao;
import com.emipaylelo.model.Product;
import com.emipaylelo.model.ProductCategory;

public class ProductMain {
	public static void main(String[] args){
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
		ProductController productController = context.getBean(ProductController.class);
		
		
//		ProductDao productDao = new ProductDao();
		
		Product samsungMobile = new Product();
		samsungMobile.setProductPrice(15000);
		samsungMobile.setProductCategory(ProductCategory.ELECTRONICS);
		samsungMobile.setProductDetails("Samsung Mobile M21S");
		samsungMobile.setProductName("Samsung M21S");
		samsungMobile.setProductUrl("https://www.google.com");
		samsungMobile.setDownPayment(2000);
		
		Product nikeShoes = new Product();
		nikeShoes.setProductPrice(5000);
		nikeShoes.setProductCategory(ProductCategory.FASHION);
		nikeShoes.setProductDetails("best shoes");
		nikeShoes.setProductName("Nike Air Force One");
		nikeShoes.setProductUrl("https://www.google.com");
		nikeShoes.setDownPayment(500);
		
		Product diningTable = new Product();
		diningTable.setProductPrice(12000);
		diningTable.setProductCategory(ProductCategory.HOME_DECOR);
		diningTable.setProductDetails("best dinner table");
		diningTable.setProductName("PepperFry Dining Table");
		diningTable.setProductUrl("https://www.google.com");
		diningTable.setDownPayment(2000);
		
		
		productController.addOrUpdateProduct(samsungMobile);
		productController.addOrUpdateProduct(nikeShoes);
		productController.addOrUpdateProduct(diningTable);
		
	}
}
