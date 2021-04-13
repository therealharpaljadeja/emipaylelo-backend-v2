package com.emipaylelo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_transaction")
public class Transaction {

	@Id
	@SequenceGenerator(name="transaction_seq", initialValue = 801, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transaction_seq")
	int transactionId;

	@Column(name = "amount")
	int amount;

	// Is transaction a down payment or an installment.
	@Column(name = "transaction_type")
	TransactionType transactionType;

	// Date at which transaction is paid.
	@Column(name = "transaction_payment_date")
	LocalDate transactionPaymentDate;
	
	// Date before which transaction is supposed to be completed.
	@Column(name = "transaction_due_date")
	LocalDate transactionDueDate;

	// Indicates whether transaction is pending or not.
	@Column(name="transaction_status")
	Boolean transactionStatus = false;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;

	@ManyToOne
	@JoinColumn(name = "card_id")
	Card card;

	@ManyToOne
	@JoinColumn(name = "order_id")
	Order order;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	

	public LocalDate getTransactionPaymentDate() {
		return transactionPaymentDate;
	}

	public void setTransactionPaymentDate(LocalDate transactionPaymentDate) {
		this.transactionPaymentDate = transactionPaymentDate;
	}

	public LocalDate getTransactionDueDate() {
		return transactionDueDate;
	}

	public void setTransactionDueDate(LocalDate transactionDueDate) {
		this.transactionDueDate = transactionDueDate;
	}
	
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@JsonIgnore
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	@JsonIgnore
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Boolean getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(Boolean transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	
}
