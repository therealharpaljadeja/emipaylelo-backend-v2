package com.emipaylelo.dao;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.Card;

@Component
public interface CardInt {
	
	public Card viewCardByCardId(int cardId);
	
	public Card addOrUpdateCard(Card card);
	
	public Card ReduceCardLimit(int cardId, int reduceByAmount);


}
