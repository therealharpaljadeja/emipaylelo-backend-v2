package com.emipaylelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.emipaylelo.model.BankDetail;
import com.emipaylelo.service.BankDetailService;

@RestController
@CrossOrigin
public class BankDetailContoller {

	@Autowired
	BankDetailService bankDetailService;
	
	public BankDetail addBankDetail(BankDetail bankDetail) {
		// TODO Auto-generated method stub
		return bankDetailService.addBankDetail(bankDetail);
	}
}
