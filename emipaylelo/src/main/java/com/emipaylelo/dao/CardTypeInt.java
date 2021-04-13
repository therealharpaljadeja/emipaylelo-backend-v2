package com.emipaylelo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.CardType;

@Component
public interface CardTypeInt {
	public CardType viewCardTypeFromCardTypeId(int cardTypeId);
	public CardType addOrUpdateCardType(CardType cardType);
	public List<CardType> getCardTypes();
}
