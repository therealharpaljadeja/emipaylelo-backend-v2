package com.emipaylelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.emipaylelo.dao.CardInt;
import com.emipaylelo.model.Card;

@Service
public class CardServiceImpl implements CardService {
	
    @Autowired
	CardInt cardInt;
    
	public Card viewCardByCardId(int cardId) {
		// TODO Auto-generated method stub
		return cardInt.viewCardByCardId(cardId);
	}

	public Card addOrUpdateCard(Card card) {
		// TODO Auto-generated method stub
		return cardInt.addOrUpdateCard(card);
	}

	public Card ReduceCardLimit(int cardId, int reduceByAmount) {
		// TODO Auto-generated method stub
		return cardInt.ReduceCardLimit(cardId, reduceByAmount);
	}

}
