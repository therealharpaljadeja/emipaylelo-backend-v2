package com.emipaylelo.dao;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.JoiningFee;

@Component
public interface JoiningFeeInt {

	public JoiningFee addJoiningFee(JoiningFee joiningFee);
}
