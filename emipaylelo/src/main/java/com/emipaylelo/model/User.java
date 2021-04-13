package com.emipaylelo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_users")
public class User {
	
	@Id
	@SequenceGenerator(name="user_seq", initialValue = 901, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
	int userId;
	
	@Column(name="user_name")
    String userName;
	
	@Column(name="user_mobile_no")
    String userMobileNo;
	
	@Column(name="user_email")
    String userEmail;
	
	@Column(name="aadhar_no")
    String aadharNo;
	
	@Column(name="pan_no")
    String panNo;
	
	@Column(name="aadhar_url")
    String aadharUrl;
	
	@Column(name="pan_url")
    String panUrl;
	
	@Column(name="user_password")
    String userPassword;
	
	@Column(name="is_approved")
    Boolean isApproved = false;
    
	@Column(name="user_address")
	String userAddress;
	
    @OneToOne(mappedBy="user")
    BankDetail bankdetail;
    
    @OneToOne(mappedBy="user")
    JoiningFee joiningfee;
    
    @OneToOne(mappedBy="user")
    Card card;
    
    @OneToMany(mappedBy="user")
    List<Order> orders;
    
    @OneToMany(mappedBy="user")
    List<Transaction> transactions;
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMobileNo() {
		return userMobileNo;
	}
	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	public String getAadharUrl() {
		return aadharUrl;
	}
	public void setAadharUrl(String aadharUrl) {
		this.aadharUrl = aadharUrl;
	}
	public String getPanUrl() {
		return panUrl;
	}
	public void setPanUrl(String panUrl) {
		this.panUrl = panUrl;
	}
	public JoiningFee getJoiningfee() {
		return joiningfee;
	}
	public void setJoiningfee(JoiningFee joiningfee) {
		this.joiningfee = joiningfee;
	}
	
	public BankDetail getBankdetail() {
		return bankdetail;
	}
	public void setBankdetail(BankDetail bankdetail) {
		this.bankdetail = bankdetail;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	@JsonIgnore
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@JsonIgnore
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	
	
    
    
}
