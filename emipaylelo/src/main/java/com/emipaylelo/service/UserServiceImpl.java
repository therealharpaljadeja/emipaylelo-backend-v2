package com.emipaylelo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.emipaylelo.dao.OrderInt;
import com.emipaylelo.dao.UserInt;
import com.emipaylelo.dto.BankDetailsDTO;
import com.emipaylelo.dto.DocumentDetailsDTO;
import com.emipaylelo.model.BankDetail;
import com.emipaylelo.model.Card;
import com.emipaylelo.model.CardType;
import com.emipaylelo.model.Order;
import com.emipaylelo.model.Transaction;
import com.emipaylelo.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserInt userInt;
	
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userInt.registerUser(user);
	}

	public User viewUserByUserId(int userId) {
		// TODO Auto-generated method stub
		return userInt.viewUserByUserId(userId);
	}

	public boolean loginUser(String userEmail, String userPassword) {
		// TODO Auto-generated method stub
		return userInt.loginUser(userEmail, userPassword);
	}

	public boolean hasUserPaidJoiningFee(int userId) {
		// TODO Auto-generated method stub
		return userInt.hasUserPaidJoiningFee(userId);
	}

	public boolean hasUserUploadedDocuments(int userId) {
		// TODO Auto-generated method stub
		return userInt.hasUserUploadedDocuments(userId);
	}

	public boolean isUserApproved(int userId) {
		// TODO Auto-generated method stub
		return userInt.isUserApproved(userId);
	}

	public CardType viewCardTypeFromUserId(int userId) {
		// TODO Auto-generated method stub
		return userInt.viewCardTypeFromUserId(userId);
	}

	public Card viewCardDetailsFromUserId(int userId) {
		// TODO Auto-generated method stub
		return userInt.viewCardDetailsFromUserId(userId);
	}

	public List<Order> viewUserOrdersFromUserId(int userId) {
		// TODO Auto-generated method stub
		return userInt.viewUserOrdersFromUserId(userId);
	}

	public List<Transaction> viewTransactionsFromUserId(int userId) {
		// TODO Auto-generated method stub
		return userInt.viewTransactionsFromUserId(userId);
	}

	public int viewRemainingCreditLimitFromUserId(int userId) {
		// TODO Auto-generated method stub
		return userInt.viewRemainingCreditLimitFromUserId(userId);
	}

	public boolean isUserCardActive(int userId) {
		// TODO Auto-generated method stub
		return userInt.isUserCardActive(userId);
	}

	public LocalDate viewUserCardExpiryDate(int userId) {
		// TODO Auto-generated method stub
		return userInt.viewUserCardExpiryDate(userId);
	}

	public BankDetail viewUserBankDetails(int userId) {
		// TODO Auto-generated method stub
		return userInt.viewUserBankDetails(userId) ;
	}

	public LocalDate viewJoiningFeePaidDateFromUserId(int userId) {
		// TODO Auto-generated method stub
		return userInt.viewJoiningFeePaidDateFromUserId(userId);
	}

	public User changePassword(String oldPassword, String newPassword, int userId) {
		// TODO Auto-generated method stub
		return userInt.changePassword(oldPassword, newPassword, userId);
	}
	
	public User setUserBankDetails(int userId, BankDetailsDTO bankDetailsDTO){
		return userInt.setUserBankDetails(userId, bankDetailsDTO);
	}

	public User setUserDocumentDetails(int userId, DocumentDetailsDTO documentDetailsDTO) {
		// TODO Auto-generated method stub
		return userInt.setUserDocumentDetails(userId, documentDetailsDTO);
	}
	
	public User setUserCardType(int userId, int cardTypeId){
		return userInt.setUserCardType(userId, cardTypeId);
	}
	
	public Order buyProduct(int userId, int productId, int tenure){
		return userInt.buyProduct(userId, productId, tenure);
	}
	
	public Transaction makePayment(int transactionId){
		return userInt.makePayment(transactionId);
	}
	
}
