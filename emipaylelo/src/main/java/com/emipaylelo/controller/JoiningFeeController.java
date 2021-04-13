package com.emipaylelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.emipaylelo.model.JoiningFee;
import com.emipaylelo.service.JoiningFeeService;

@RestController
@CrossOrigin
public class JoiningFeeController {

	@Autowired
	JoiningFeeService joiningFeeService;
	
	public JoiningFee addJoiningFee(JoiningFee joiningFee) {
		// TODO Auto-generated method stub
		return joiningFeeService.addJoiningFee(joiningFee);
	}
	
}
