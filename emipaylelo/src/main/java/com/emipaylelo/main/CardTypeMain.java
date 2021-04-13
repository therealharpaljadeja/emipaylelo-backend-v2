package com.emipaylelo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.emipaylelo.controller.CardTypeController;
import com.emipaylelo.dao.CardTypeDao;
import com.emipaylelo.model.CardType;
import com.emipaylelo.model.CardTypeEnum;

public class CardTypeMain {
	public static void main(String[] args){
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
		CardTypeController cardTypeController = context.getBean(CardTypeController.class);
		// Adding Gold Card Type
		CardType goldCard = new CardType();
		goldCard.setCardType(CardTypeEnum.GOLD);
		goldCard.setCardExpiry(5);
		goldCard.setCardJoiningFee(500);
		goldCard.setCardLimit(50000);
		
		// Adding Titanium Card Type
		CardType titaniumCard = new CardType();
		titaniumCard.setCardType(CardTypeEnum.TITANIUM);
		titaniumCard.setCardExpiry(5);
		titaniumCard.setCardJoiningFee(1000);
		titaniumCard.setCardLimit(100000);
		System.out.println("CardType Creation");
//		CardTypeDao cardTypeDao = new CardTypeDao();
//		cardTypeController.addOrUpdateCardType(titaniumCard);
		cardTypeController.addOrUpdateCardType(goldCard);
	}
}
