package com.emipaylelo.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emipaylelo.controller.BankDetailContoller;
import com.emipaylelo.controller.CardController;
import com.emipaylelo.controller.CardTypeController;
import com.emipaylelo.controller.JoiningFeeController;
import com.emipaylelo.controller.OrderController;
import com.emipaylelo.controller.ProductController;
import com.emipaylelo.controller.TransactionController;
import com.emipaylelo.dto.BankDetailsDTO;
import com.emipaylelo.dto.DocumentDetailsDTO;
import com.emipaylelo.model.BankDetail;
import com.emipaylelo.model.Card;
import com.emipaylelo.model.CardType;
import com.emipaylelo.model.JoiningFee;
import com.emipaylelo.model.Order;
import com.emipaylelo.model.Product;
import com.emipaylelo.model.Transaction;
import com.emipaylelo.model.User;
import com.emipaylelo.service.BankDetailService;
import com.emipaylelo.service.BankDetailServiceImpl;
@Repository
public class UserDao implements UserInt {
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	BankDetailContoller bankDetailController;
	
	@Autowired
	CardTypeController cardTypeController;
	
	@Autowired
	JoiningFeeController joiningFeeController;
	
	@Autowired
	ProductController productController;
	
	@Autowired
	OrderController orderController;
	
	@Autowired
	TransactionController transactionController;
	
	public UserDao(){
		
	}
	@Transactional
	public User registerUser(User user){
		System.out.println(em);
		User userPersisted = em.merge(user);
		
		return userPersisted;
	}
	
	public User viewUserByUserId(int userId){
		return em.find(User.class, userId);
	}
	
	public boolean loginUser(String userEmail, String userPassword){
		String jpql = "select u from User u where user.userEmail=:uemail";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("uemail", userEmail);
		User user = query.getSingleResult();
		if(user.getUserPassword().equals(userPassword)) {
			return true;
		}
		return false;
	}

	public boolean hasUserPaidJoiningFee(int userId){
		User user = viewUserByUserId(userId);
		if(user.getJoiningfee() != null)
			return true;
		return false;
	}
	
	public boolean hasUserUploadedDocuments(int userId){
		User user = viewUserByUserId(userId);
		if(user.getAadharUrl() != null && user.getPanUrl() != null) 
			return true;
		return false;
	}
	
	public boolean isUserApproved(int userId){
		User user = viewUserByUserId(userId);
		return user.getIsApproved();
	}
	
	public CardType viewCardTypeFromUserId(int userId){
		User user = viewUserByUserId(userId);
		return user.getCard().getCardType();
	}
	
	public Card viewCardDetailsFromUserId(int userId){
		User user = viewUserByUserId(userId);
		return user.getCard();
	}
	
	public List<Order> viewUserOrdersFromUserId(int userId){
		User user = viewUserByUserId(userId);
		return user.getOrders();
	}
	
	public List<Transaction> viewTransactionsFromUserId(int userId){
		User user = viewUserByUserId(userId);
		return user.getTransactions();
	}
	
	public int viewRemainingCreditLimitFromUserId(int userId){
		User user = viewUserByUserId(userId);
		return user.getCard().getCardRemainingLimit();
	}
	
	public boolean isUserCardActive(int userId){
		User user = viewUserByUserId(userId);
		return user.getCard().getIsActive();
	}
	
	public LocalDate viewUserCardExpiryDate(int userId){
		User user = viewUserByUserId(userId);
		return user.getCard().getCardExpiryDate();
	}
	
	public BankDetail viewUserBankDetails(int userId){
		User user = viewUserByUserId(userId);
		return user.getBankdetail();
	}
	
	public LocalDate viewJoiningFeePaidDateFromUserId(int userId){
		User user = viewUserByUserId(userId);
		return user.getJoiningfee().getJoiningFeeDate();
	}
	@Transactional
	public User changePassword(String oldPassword, String newPassword, int userId){
		User user = viewUserByUserId(userId);
		if(user.getUserPassword().equals(oldPassword)){
			user.setUserPassword(newPassword);
			User userPersisted = registerUser(user);
			return userPersisted;
		}
		System.out.println("Incorrect Old Password");
		return null;
	}
	@Transactional
	public User setUserBankDetails(int userId, BankDetailsDTO bankDetailsDTO) {
		User user = viewUserByUserId(userId);
		BankDetail bankDetail = new BankDetail();
		
		bankDetail.setBankAccountNo(bankDetailsDTO.getBankAccountNo());
		bankDetail.setBankIfsc(bankDetailsDTO.getBankIfsc());
		bankDetail.setBankName(bankDetailsDTO.getBankName());
		bankDetail.setUser(user);
//		BankDetailService bankDetailService = new BankDetailServiceImpl();
		BankDetail bankDetailPersisted = bankDetailController.addBankDetail(bankDetail);
		
		user.setBankdetail(bankDetailPersisted);
		User userPersisted = registerUser(user);
		return userPersisted;
	}
	@Transactional
	public User setUserDocumentDetails(int userId, DocumentDetailsDTO documentDetailsDTO) {
		User user = viewUserByUserId(userId);
		user.setAadharNo(documentDetailsDTO.getAadharNo());
		user.setAadharUrl(documentDetailsDTO.getAadharUrl());
		user.setPanNo(documentDetailsDTO.getPanNo());
		user.setPanUrl(documentDetailsDTO.getPanUrl());
		User userPersisted = registerUser(user);
		return userPersisted;
	}
	
	@Transactional
	public User setUserCardType(int userId, int cardTypeId){
		CardType cardType = cardTypeController.viewCardTypeFromCardTypeId(cardTypeId);
		User user = viewUserByUserId(userId);
		JoiningFee joiningFee = new JoiningFee();
		joiningFee.setCardType(cardType);
		joiningFee.setUser(user);
		JoiningFee joiningFeePersisted = joiningFeeController.addJoiningFee(joiningFee);
		user.setJoiningfee(joiningFeePersisted);
		User userPersisted = registerUser(user);
		return userPersisted;
	}
	

	public Order buyProduct(int userId, int productId, int tenure){
		Product product = productController.viewProductByProductId(productId);
		User user = viewUserByUserId(userId);
		Card card = user.getCard();
		
		if(isCardValidForPurchase(card, product)){
			Order order = createOrder(user, card, product, tenure);
			order = transactionController.generateTransactionsForOrder(order);
			Order orderPersisted = orderController.addOrder(order);
			return orderPersisted;
		}
		System.out.println("Card Invalid");
		return null;
	}
	
	public Order createOrder(User user, Card card, Product product, int tenure){
		Order order = new Order();
		order.setCard(card);
		order.setUser(user);
		order.setOrderAmount(product.getProductPrice());
		order.setProduct(product);
		order.setShippingAddress(user.getUserAddress());
		order.setTenure(tenure);
		Order orderPersisted = orderController.addOrder(order);
		return orderPersisted;
	}
	
	public boolean isCardValidForPurchase(Card card, Product product){
		if(card.getIsActive() && card.getCardRemainingLimit() >= product.getProductPrice())
			return true;
		return false;
	}
	
	public Transaction makePayment(int transactionId){
		Transaction transaction = transactionController.viewTransactionByTransactionId(transactionId);
		Transaction transactionPersisted = transactionController.payTransaction(transaction);
		if(transactionPersisted != null) {
			return transactionPersisted;
		}
		System.out.println("Payment Failed");
		return null;
	}
	
	
}
