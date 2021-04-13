package com.emipaylelo.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emipaylelo.model.CardType;
@Component
public class CardTypeDao implements CardTypeInt{
	@PersistenceContext
	EntityManager em;
	
	
	public CardTypeDao(){
		
	}
	@Transactional
	public CardType addOrUpdateCardType(CardType cardType){
		CardType cardTypePersisted = em.merge(cardType);	
		return cardTypePersisted;
	}
	
	public CardType viewCardTypeFromCardTypeId(int cardTypeId){
		return em.find(CardType.class, cardTypeId);
	}
	
	public List<CardType> getCardTypes() {
		// TODO Auto-generated method stub
		String jpql = "select c from CardType c";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	
}
