package com.emipaylelo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_card")
public class Card {

	@Id
	@SequenceGenerator(name="card_seq", initialValue = 301, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="card_seq")
	int cardId;
	
	
	@Column(name="card_no")
	int cardNo;
	
	@Column(name="card_expiry_date")
	LocalDate cardExpiryDate;
	
	@Column(name="is_active")
	Boolean isActive;
	
	@Column(name="card_remaining_limit")
	int cardRemainingLimit;
	
	@Column(name="card_cvv")
	int cvv;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	User user;

	@OneToMany
	@JoinColumn(name = "order_id")
	List<Order> orders;

	@OneToMany
	@JoinColumn(name = "transaction_id")
	List<Transaction> transactions;

	@ManyToOne
	@JoinColumn(name = "cardtype_id")
	CardType cardType;

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	
	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public LocalDate getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(LocalDate cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public int getCardRemainingLimit() {
		return cardRemainingLimit;
	}

	public void setCardRemainingLimit(int cardRemainingLimit) {
		this.cardRemainingLimit = cardRemainingLimit;
	}
	
	

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@JsonIgnore
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@JsonIgnore
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
