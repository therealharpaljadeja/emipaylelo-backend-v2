package com.emipaylelo.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emipaylelo.model.Card;

@Repository
public class CardDao implements CardInt{
	@PersistenceContext
	EntityManager em;
	
	
	public CardDao(){
		
	}
	
	@Transactional
	public Card viewCardByCardId(int cardId){
		System.out.println(em);
		
		return em.find(Card.class, cardId);
	}
	@Transactional
	public Card addOrUpdateCard(Card card){
		System.out.println(card);
		Card cardPersisted = em.merge(card);
		System.out.println(cardPersisted);
		return cardPersisted;
	}
	@Transactional
	public Card ReduceCardLimit(int cardId, int reduceByAmount){
		Card card = viewCardByCardId(cardId);
		card.setCardRemainingLimit(card.getCardRemainingLimit() - reduceByAmount);
		Card cardPersisted = addOrUpdateCard(card);
		return cardPersisted;
	}
}
