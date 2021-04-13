package com.emipaylelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.emipaylelo.model.Order;
import com.emipaylelo.model.Transaction;
import com.emipaylelo.service.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	public Transaction addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionService.addTransaction(transaction);
	}

	public Transaction payTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionService.payTransaction(transaction);
	}

	public Transaction viewTransactionByTransactionId(int transactionId) {
		// TODO Auto-generated method stub
		return transactionService.viewTransactionByTransactionId(transactionId);
	}

	public Order generateTransactionsForOrder(Order order) {
		// TODO Auto-generated method stub
		return transactionService.generateTransactionsForOrder(order);
	}

}
