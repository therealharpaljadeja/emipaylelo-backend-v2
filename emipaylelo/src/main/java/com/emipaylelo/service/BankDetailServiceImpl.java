package com.emipaylelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.emipaylelo.dao.BankDetailInt;
import com.emipaylelo.model.BankDetail;

@Service
public class BankDetailServiceImpl implements BankDetailService {
	
    @Autowired
	BankDetailInt bankDetailInt;
    
	public BankDetail addBankDetail(BankDetail bankDetail) {
		// TODO Auto-generated method stub
		return bankDetailInt.addBankDetail(bankDetail);
	}

}
