package com.emipaylelo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_order")
public class Order {
	
	@Id
	@SequenceGenerator(name="order_seq", initialValue = 601, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order_seq")
    int orderId;
	
	@Column(name="order_amount")
    int orderAmount;
	
	@Column(name="tenure")
    int tenure;
	
	@Column(name="order_date")
    LocalDate orderDate = LocalDate.now();
	
	@Column(name="shipping_address")
    String shippingAddress;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    User user;
    
    @ManyToOne
    @JoinColumn(name="product_id")
    Product product;
    
    @ManyToOne
    @JoinColumn(name="card_id")
    Card card;
    
    @OneToMany(mappedBy="order")
    List<Transaction> transactions;
    
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	@JsonIgnore
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
    
    
}
