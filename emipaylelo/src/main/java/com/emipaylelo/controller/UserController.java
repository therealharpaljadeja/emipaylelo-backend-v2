package com.emipaylelo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emipaylelo.dto.BankDetailsDTO;
import com.emipaylelo.dto.BuyProductDTO;
import com.emipaylelo.dto.CardSelectionDTO;
import com.emipaylelo.dto.ChangePasswordDTO;
import com.emipaylelo.dto.DocumentDetailsDTO;
import com.emipaylelo.dto.LoginDTO;
import com.emipaylelo.dto.MakePaymentDTO;
import com.emipaylelo.model.BankDetail;
import com.emipaylelo.model.Card;
import com.emipaylelo.model.CardType;
import com.emipaylelo.model.Order;
import com.emipaylelo.model.Transaction;
import com.emipaylelo.model.User;
import com.emipaylelo.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
	//http://localhost:9090/emipaylelo/rest/registerUser
	@PostMapping(value="/registerUser")
	public User registerUser(@RequestBody User user) {
		// TODO Auto-generated method stub
		return userService.registerUser(user);
	}
	
	@RequestMapping(value="/getUser",method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User viewUserByUserId(@RequestParam("userId") int userId) {
		// TODO Auto-generated method stub
		return userService.viewUserByUserId(userId);
	}
	
	@PostMapping(value="/loginUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean loginUser(@RequestBody LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return userService.loginUser(loginDTO.getUserEmail(), loginDTO.getUserPassword());
	}

	@RequestMapping(value="/hasPaidJoiningFee")
	public boolean hasUserPaidJoiningFee(@RequestParam int userId) {
		// TODO Auto-generated method stub
		return userService.hasUserPaidJoiningFee(userId);
	}
	
	@RequestMapping(value="/hasUploadDocuments")
	public boolean hasUserUploadedDocuments(@RequestParam int userId) {
		// TODO Auto-generated method stub
		return userService.hasUserUploadedDocuments(userId);
	}
	
	@RequestMapping(value="/isUserApproved")
	public boolean isUserApproved(int userId) {
		// TODO Auto-generated method stub
		return userService.isUserApproved(userId);
	}
	
	@RequestMapping(value="/getCardType")
	public CardType viewCardTypeFromUserId(@RequestParam int userId) {
		// TODO Auto-generated method stub
		return userService.viewCardTypeFromUserId(userId);
	}
	
	@RequestMapping(value="/getCardDetails")
	public Card viewCardDetailsFromUserId(@RequestParam int userId) {
		// TODO Auto-generated method stub
		return userService.viewCardDetailsFromUserId(userId);
	}
	
	@RequestMapping(value="/getOrders")
	public List<Order> viewUserOrdersFromUserId(@RequestParam int userId) {
		// TODO Auto-generated method stub
		return userService.viewUserOrdersFromUserId(userId);
	}
	
	@RequestMapping(value="/getTransactions")
	public List<Transaction> viewTransactionsFromUserId(@RequestParam int userId) {
		// TODO Auto-generated method stub
		return userService.viewTransactionsFromUserId(userId);
	}

	@RequestMapping(value="/getRemainingCreditLimit")
	public int viewRemainingCreditLimitFromUserId(@RequestParam int userId) {
		// TODO Auto-generated method stub
		return userService.viewRemainingCreditLimitFromUserId(userId);
	}

	@RequestMapping(value="/getIsCardActive")
	public boolean isUserCardActive(@RequestParam int userId) {
		// TODO Auto-generated method stub
		return userService.isUserCardActive(userId);
	}

	@RequestMapping(value="/getCardExpiryDate")
	public LocalDate viewUserCardExpiryDate(@RequestParam int userId) {
		// TODO Auto-generated method stub
		return userService.viewUserCardExpiryDate(userId);
	}

	@RequestMapping(value="/getUserBankDetails")
	public BankDetail viewUserBankDetails(@RequestParam int userId) {
		// TODO Auto-generated method stub
		return userService.viewUserBankDetails(userId) ;
	}
	
	@RequestMapping(value="/getJoiningFeePaidDate")
	public LocalDate viewJoiningFeePaidDateFromUserId(@RequestParam int userId) {
		// TODO Auto-generated method stub
		return userService.viewJoiningFeePaidDateFromUserId(userId);
	}
	
	@PostMapping(value="/changePassword")
	public User changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
		// TODO Auto-generated method stub
		return userService.changePassword(changePasswordDTO.getOldPassword(), changePasswordDTO.getNewPassword(), changePasswordDTO.getUserId());
	}
	
	@PostMapping(value="/setUserBankDetails")
	public User setUserBankDetails(@RequestBody BankDetailsDTO bankDetailsDTO, @RequestParam("userId") int userId){
		return userService.setUserBankDetails(userId, bankDetailsDTO);
	}
	
	@PostMapping(value="/setUserDocumentDetails")
	public User setUserDocumentDetails(@RequestParam("userId") int userId,@RequestBody DocumentDetailsDTO documentDetailsDTO){
		return userService.setUserDocumentDetails(userId, documentDetailsDTO);
	}
	
	@PostMapping(value="/setUserCardType")
	public User setUserCardType(@RequestParam("userId") int userId, @RequestBody CardSelectionDTO cardSelectionDTO){
		return userService.setUserCardType(userId, cardSelectionDTO.getCardTypeId());
	}
	
	@PostMapping(value="/buyProduct")
	public Order buyProduct(int userId,@RequestBody BuyProductDTO buyProductDTO){
		return userService.buyProduct(userId, buyProductDTO.getProductId(), buyProductDTO.getTenure());
	}
	
	@PostMapping(value="/makePayment")
	public Transaction makePayment(int userId, @RequestBody MakePaymentDTO makePaymentDTO){
		return userService.makePayment(makePaymentDTO.getTransactionId());
	}
	
	
	
}
