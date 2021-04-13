package com.emipaylelo.service;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.Card;
@Component
public interface CardService {

    public Card viewCardByCardId(int cardId);
	
	public Card addOrUpdateCard(Card card);
	
	public Card ReduceCardLimit(int cardId, int reduceByAmount);

}
