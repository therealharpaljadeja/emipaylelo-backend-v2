package com.emipaylelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.emipaylelo.dao.CardTypeInt;
import com.emipaylelo.model.CardType;

@Service
public class CardTypeServiceImpl implements CardTypeService {
	
    @Autowired
	CardTypeInt cardTypeInt;

	public CardType addOrUpdateCardType(CardType cardType) {
		// TODO Auto-generated method stub
		return cardTypeInt.addOrUpdateCardType(cardType);
	}

	public CardType viewCardTypeFromCardTypeId(int cardTypeId) {
		// TODO Auto-generated method stub
		return cardTypeInt.viewCardTypeFromCardTypeId(cardTypeId);
	}

	public List<CardType> getCardTypes() {
		// TODO Auto-generated method stub
		return cardTypeInt.getCardTypes();
	}
	
	
}
