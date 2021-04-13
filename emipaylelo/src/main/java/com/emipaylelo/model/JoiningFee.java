package com.emipaylelo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_joiningfee")
public class JoiningFee {
	  
	 @Id
	 @SequenceGenerator(name="joining_fee_seq", initialValue = 501, allocationSize = 1)
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="joining_fee_seq")
     int joiningFeeId;
	 
     
     @Column(name="joining_fee_date")
     LocalDate joiningFeeDate = LocalDate.now();
     
     @OneToOne
     @JoinColumn(name="user_id")
     User user;
     
     @ManyToOne
     @JoinColumn(name="cardType_id")
     CardType cardType;
     
	public int getJoiningFeeId() {
		return joiningFeeId;
	}
	public void setJoiningFeeId(int joiningFeeId) {
		this.joiningFeeId = joiningFeeId;
	}
	
	public LocalDate getJoiningFeeDate() {
		return joiningFeeDate;
	}
	public void setJoiningFeeDate(LocalDate joiningFeeDate) {
		this.joiningFeeDate = joiningFeeDate;
	}
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public CardType getCardType() {
		return cardType;
	}
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
}
