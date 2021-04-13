package com.emipaylelo.service;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.Order;
import com.emipaylelo.model.Transaction;
@Component
public interface TransactionService {

	public Transaction addTransaction(Transaction transaction);
	
	public Transaction payTransaction(Transaction transaction);
	
	public Transaction viewTransactionByTransactionId(int transactionId);
	
	public Order generateTransactionsForOrder(Order order);
}
