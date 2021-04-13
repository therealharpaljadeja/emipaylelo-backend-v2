package com.emipaylelo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_cardtype")
public class CardType {

	@Id
	@SequenceGenerator(name="card_type_seq", initialValue = 401, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="card_type_seq")
	int cardTypeId;

	@Column(name="card_type")
	CardTypeEnum cardType;
	
	@Column(name="card_joining_fee")
	int cardJoiningFee;
	
	@Column(name="card_expiry")
	int cardExpiry;
	
	@Column(name="card_limit")
	int cardLimit;

	@OneToMany(mappedBy = "cardType")
	List<JoiningFee> joiningfee;

	@OneToMany(mappedBy = "cardType")
	List<Card> cards;

	public int getCardTypeId() {
		return cardTypeId;
	}

	public void setCardTypeId(int cardTypeId) {
		this.cardTypeId = cardTypeId;
	}

	public CardTypeEnum getCardType() {
		return cardType;
	}

	public void setCardType(CardTypeEnum cardType) {
		this.cardType = cardType;
	}
	
	public int getCardJoiningFee() {
		return cardJoiningFee;
	}

	public void setCardJoiningFee(int cardJoiningFee) {
		this.cardJoiningFee = cardJoiningFee;
	}

	public int getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(int cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	
	@JsonIgnore
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public int getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(int cardLimit) {
		this.cardLimit = cardLimit;
	}
	@JsonIgnore
	public List<JoiningFee> getJoiningfee() {
		return joiningfee;
	}

	public void setJoiningfee(List<JoiningFee> joiningfee) {
		this.joiningfee = joiningfee;
	}

}
