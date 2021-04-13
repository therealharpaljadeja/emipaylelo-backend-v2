package com.emipaylelo.dao;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.BankDetail;

@Component
public interface BankDetailInt {
	
	public BankDetail addBankDetail(BankDetail bankDetail);
}
