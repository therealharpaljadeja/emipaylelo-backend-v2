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

import com.emipaylelo.controller.CardController;
import com.emipaylelo.controller.CardTypeController;
import com.emipaylelo.controller.UserController;
import com.emipaylelo.model.Admin;
import com.emipaylelo.model.Card;
import com.emipaylelo.model.CardType;
import com.emipaylelo.model.User;
@Repository
public class AdminDao implements AdminInt {
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	UserController userController;
	
	@Autowired
	CardTypeController cardTypeController;
	
	@Autowired
	CardController cardController;
	
	public AdminDao(){
		
	}
	@Transactional
	public boolean adminLogin(String adminEmail, String adminPassword){
		String jpql = "select a from Admin a where a.emailId=:aemail";
		TypedQuery<Admin> query = em.createQuery(jpql, Admin.class);
		query.setParameter("aemail", adminEmail);
		Admin admin = query.getSingleResult();
		if(admin.getPassword().equals(adminPassword)) {
			return true;
		}
		return false;
	}
	@Transactional
	public void approveUser(int userId){
//		UserDao userDao = new UserDao();
		User user = userController.viewUserByUserId(userId);
		user.setIsApproved(true);
		
		CardType cardType = user.getJoiningfee().getCardType();
		
		Card card = new Card();
		card.setCardExpiryDate(LocalDate.now().plusYears(cardType.getCardExpiry()));
		card.setCardNo(12312312);
		card.setCardType(cardType);
		card.setCardRemainingLimit(cardType.getCardLimit());
		card.setCvv(231);
		card.setUser(user);
		card.setIsActive(true);
		
		Card cardPersisted = cardController.addOrUpdateCard(card);
		user.setCard(cardPersisted);
		userController.registerUser(user);
	}
	
	
	
	
	@Transactional
	public void toggleCardActivation(int cardId){
		Card card = cardController.viewCardByCardId(cardId);
		card.setIsActive(card.getIsActive() ? false : true);
	}
	
	public List<User> viewAllUsers(){
		String jpql = "select u from User u";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		List<User> users = query.getResultList();
		return users;
	}
}
