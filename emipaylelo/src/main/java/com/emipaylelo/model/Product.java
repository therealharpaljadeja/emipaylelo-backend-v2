package com.emipaylelo.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_product")
public class Product {
	
	@Id
	@SequenceGenerator(name="product_seq", initialValue = 701, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_seq")
    int productId;
	
	@Column(name="product_name")
    String productName;
	
	@Column(name="product_price")
    int productPrice;
	
	@Column(name="product_downpayment")
	int downPayment;
	
	@Column(name="product_url")
    String productUrl;
	
	@Column(name="product_category")
    ProductCategory productCategory;
	
	@Column(name="product_details")
    String productDetails;
    
    @OneToMany(mappedBy="product")
    List<Order> orders;
    
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	
	@JsonIgnore
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public int getDownPayment() {
		return downPayment;
	}
	public void setDownPayment(int downPayment) {
		this.downPayment = downPayment;
	}
    
    
}
