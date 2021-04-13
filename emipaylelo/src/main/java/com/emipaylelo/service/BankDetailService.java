package com.emipaylelo.service;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.BankDetail;
@Component
public interface BankDetailService {

	public BankDetail addBankDetail(BankDetail bankDetail);
}
