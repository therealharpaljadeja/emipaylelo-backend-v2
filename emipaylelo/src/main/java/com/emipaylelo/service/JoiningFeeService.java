package com.emipaylelo.service;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.JoiningFee;
@Component
public interface JoiningFeeService {

	public JoiningFee addJoiningFee(JoiningFee joiningFee);
}
