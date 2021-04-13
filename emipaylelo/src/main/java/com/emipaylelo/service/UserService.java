package com.emipaylelo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.emipaylelo.dto.BankDetailsDTO;
import com.emipaylelo.dto.DocumentDetailsDTO;
import com.emipaylelo.model.BankDetail;
import com.emipaylelo.model.Card;
import com.emipaylelo.model.CardType;
import com.emipaylelo.model.Order;
import com.emipaylelo.model.Transaction;
import com.emipaylelo.model.User;
@Component
public interface UserService {

public User registerUser(User user);
	
	public User viewUserByUserId(int userId);
	
	public boolean loginUser(String userEmail, String userPassword);
	
	public boolean hasUserPaidJoiningFee(int userId);
	
	public boolean hasUserUploadedDocuments(int userId);
	
	public boolean isUserApproved(int userId);
	
	public CardType viewCardTypeFromUserId(int userId);
	
	public Card viewCardDetailsFromUserId(int userId);
	
	public List<Order> viewUserOrdersFromUserId(int userId);
	
	public List<Transaction> viewTransactionsFromUserId(int userId);
	
	public int viewRemainingCreditLimitFromUserId(int userId);
	
	public boolean isUserCardActive(int userId);
	
	public LocalDate viewUserCardExpiryDate(int userId);
	
	public BankDetail viewUserBankDetails(int userId);
	
	public LocalDate viewJoiningFeePaidDateFromUserId(int userId);
	
	public User changePassword(String oldPassword, String newPassword, int userId);
	
	public User setUserBankDetails(int userId, BankDetailsDTO bankDetailsDTO);
	
	public User setUserDocumentDetails(int userId, DocumentDetailsDTO documentDetailsDTO);
	
	public User setUserCardType(int userId, int cardTypeId);
	
	public Order buyProduct(int userId, int productId, int tenure);
	
	public Transaction makePayment(int transactionId);
}
