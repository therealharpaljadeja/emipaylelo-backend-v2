package com.emipaylelo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_admin")
public class Admin {

	@Id
	@SequenceGenerator(name="admin_seq", initialValue = 101, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="admin_seq")
	int adminId;
	
	@Column(name="email_id")
	String emailId;
	
	@Column(name="password")
	String password;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
