package com.emipaylelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emipaylelo.dto.LoginDTO;
import com.emipaylelo.model.User;
import com.emipaylelo.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping(value="/adminLogin")
	public boolean adminLogin(@RequestBody LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return adminService.adminLogin(loginDTO.getUserEmail(), loginDTO.getUserPassword());
	}

	@RequestMapping(value="/approveUser")
	public void approveUser(@RequestParam int userId) {
		// TODO Auto-generated method stub
		adminService.approveUser(userId);
		
	}
	
	@RequestMapping(value="/toggleCardActivation")
	public void toggleCardActivation(@RequestParam("cardId") int cardId) {
		// TODO Auto-generated method stub
		adminService.toggleCardActivation(cardId);
	}

	@RequestMapping(value="/getUsers")
	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return adminService.viewAllUsers();
	}

}
