package com.emipaylelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.emipaylelo.model.Card;
import com.emipaylelo.service.CardService;

@RestController
@CrossOrigin
public class CardController {

	@Autowired
	CardService cardService;
	
	public Card viewCardByCardId(int cardId) {
		// TODO Auto-generated method stub
		return cardService.viewCardByCardId(cardId);
	}

	public Card addOrUpdateCard(Card card) {
		// TODO Auto-generated method stub
		return cardService.addOrUpdateCard(card);
	}

	public Card ReduceCardLimit(int cardId, int reduceByAmount) {
		// TODO Auto-generated method stub
		return cardService.ReduceCardLimit(cardId, reduceByAmount);
	}
}
