package com.emipaylelo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_bankdetail")
public class BankDetail {
	
	@Id
	@SequenceGenerator(name="bank_details_seq", initialValue = 201, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bank_details_seq")
	int bankDetailId;
	
	@Column(name="bank_name")
    String bankName;
	
	@Column(name="bank_account_no")
    String bankAccountNo;
	
	@Column(name="bank_ifsc")
    String bankIfsc;
    
    @OneToOne
    @JoinColumn(name="user_id")
    User user;
    
	
	
	public int getBankDetailId() {
		return bankDetailId;
	}
	public void setBankDetailId(int bankDetailId) {
		this.bankDetailId = bankDetailId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	public String getBankIfsc() {
		return bankIfsc;
	}
	public void setBankIfsc(String bankIfsc) {
		this.bankIfsc = bankIfsc;
	}
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
	
    
}
