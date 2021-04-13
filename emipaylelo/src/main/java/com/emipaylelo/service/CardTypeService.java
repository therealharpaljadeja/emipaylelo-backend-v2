package com.emipaylelo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.CardType;
@Component
public interface CardTypeService {
	public CardType addOrUpdateCardType(CardType cardType);
	public CardType viewCardTypeFromCardTypeId(int cardTypeId);
	public List<CardType> getCardTypes();
}
