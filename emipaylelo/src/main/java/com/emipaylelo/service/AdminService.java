package com.emipaylelo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.User;

@Component
public interface AdminService {

	public boolean adminLogin(String adminEmail, String adminPassword);

	public void approveUser(int userId);

	public void toggleCardActivation(int cardId);

	public List<User> viewAllUsers();
}
