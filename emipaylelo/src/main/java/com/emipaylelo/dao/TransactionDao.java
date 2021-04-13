package com.emipaylelo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emipaylelo.controller.CardController;
import com.emipaylelo.model.Card;
import com.emipaylelo.model.Order;
import com.emipaylelo.model.Transaction;
import com.emipaylelo.model.TransactionType;
@Repository
public class TransactionDao implements TransactionInt{
	@PersistenceContext
	EntityManager em;
//	
	@Autowired
	CardController cardController;
	
	public TransactionDao(){
		
	}
	@Transactional
	public Transaction addTransaction(Transaction transaction){
		
//		System.out.println(transaction.getCard());
		Card card = transaction.getCard();
		int initialLimit = card.getCardRemainingLimit();
		
		// reducing card limit.
		Card cardPersisted = cardController.ReduceCardLimit(card.getCardId(), transaction.getAmount());
		
		// Updating card remaining limit in database.
		cardPersisted = cardController.addOrUpdateCard(cardPersisted);
		
		Transaction transactionPersisted = em.merge(transaction);
		return transactionPersisted;
	}
	@Transactional
	public Transaction payTransaction(Transaction transaction){
		Card card = transaction.getCard();
		if(card.getIsActive()){
			int cardLimitBeforePayment = card.getCardRemainingLimit();
			
			// Increase card limit now because pending installment or down payment has been paid.
			card.setCardRemainingLimit(cardLimitBeforePayment + transaction.getAmount());
			
			// Setting transaction status as paid.
			transaction.setTransactionStatus(true);
			transaction.setTransactionPaymentDate(LocalDate.now());
			
			cardController.addOrUpdateCard(card);
			
			Transaction transactionPersisted = em.merge(transaction);
			
			return transactionPersisted;
		} 
		return null;
		
	}
	@Transactional
	public Transaction viewTransactionByTransactionId(int transactionId){
		return em.find(Transaction.class, transactionId);
	}
	@Transactional
	public Order generateTransactionsForOrder(Order order){
		
		// Creating Down Payment Transaction
		Transaction transaction = new Transaction();
		transaction.setAmount(order.getProduct().getDownPayment());
		transaction.setOrder(order);
		transaction.setCard(order.getCard());
		
		transaction.setTransactionDueDate(LocalDate.now());
		transaction.setTransactionType(TransactionType.DOWN_PAYMENT);
		transaction.setUser(order.getUser());

		// Adding transaction to database.
		addTransaction(transaction);
		
		
		// Calculating EMI Amount
		int emiAmount = order.getProduct().getProductPrice() - order.getProduct().getDownPayment();
		emiAmount = emiAmount / order.getTenure();
				
		// Generating EMI transactions.
		for(int i = 0; i < order.getTenure(); i++){
			Transaction emiTransaction = new Transaction();
			emiTransaction.setAmount(emiAmount);
			emiTransaction.setOrder(order);
			emiTransaction.setCard(order.getCard());
			
			// Setting due dates for EMI transactions
			emiTransaction.setTransactionDueDate(LocalDate.now().plusMonths(i + 1));
			emiTransaction.setTransactionType(TransactionType.EMI);
			emiTransaction.setUser(order.getUser());
			
			// Adding EMI transaction to database.
			addTransaction(emiTransaction);
		}
		
		return order;
	}
}
