package com.emipaylelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.emipaylelo.dao.AdminInt;
import com.emipaylelo.model.User;

@Service
public class AdminServiceImpl implements AdminService {
	
   @Autowired
	AdminInt adminInt;
   
	public boolean adminLogin(String adminEmail, String adminPassword) {
		// TODO Auto-generated method stub
		return adminInt.adminLogin(adminEmail, adminPassword);
	}

	public void approveUser(int userId) {
		// TODO Auto-generated method stub
		adminInt.approveUser(userId);
	}

	public void toggleCardActivation(int cardId) {
		// TODO Auto-generated method stub
		adminInt.toggleCardActivation(cardId);
	}

	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return adminInt.viewAllUsers();
	}

}
