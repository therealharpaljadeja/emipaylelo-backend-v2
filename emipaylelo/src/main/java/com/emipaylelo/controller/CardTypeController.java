package com.emipaylelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emipaylelo.model.CardType;
import com.emipaylelo.service.CardTypeService;

@RestController
@CrossOrigin
public class CardTypeController {

	@Autowired
	CardTypeService cardTypeService;

	public CardType viewCardTypeFromCardTypeId(int cardTypeId) {
		// TODO Auto-generated method stub
		return cardTypeService.viewCardTypeFromCardTypeId(cardTypeId);
	}
	
	public CardType addOrUpdateCardType(CardType cardType) {
		return cardTypeService.addOrUpdateCardType(cardType);
	}
	
	@RequestMapping("/getCardTypes")
	public List<CardType> getCardTypes(){
		return cardTypeService.getCardTypes();
	}
	
}
