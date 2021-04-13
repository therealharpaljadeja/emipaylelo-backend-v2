package com.emipaylelo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.User;

@Component
public interface AdminInt {
	
	public boolean adminLogin(String adminEmail, String adminPassword);
	
	public void approveUser(int userId);
	
	public void toggleCardActivation(int cardId);
	
	public List<User> viewAllUsers();
	
}
