package com.emipaylelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.emipaylelo.dao.TransactionInt;
import com.emipaylelo.model.Order;
import com.emipaylelo.model.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionInt transactionInt;
	
	public Transaction addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionInt.addTransaction(transaction);
	}

	public Transaction payTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionInt.payTransaction(transaction);
	}

	public Transaction viewTransactionByTransactionId(int transactionId) {
		// TODO Auto-generated method stub
		return transactionInt.viewTransactionByTransactionId(transactionId);
	}

	public Order generateTransactionsForOrder(Order order) {
		// TODO Auto-generated method stub
		return transactionInt.generateTransactionsForOrder(order);
	}

}
