package com.emipaylelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.emipaylelo.dao.JoiningFeeInt;
import com.emipaylelo.model.JoiningFee;

@Service
public class JoiningFeeServiceImpl implements JoiningFeeService {

	@Autowired
	JoiningFeeInt joiningFeeInt;
	
	public JoiningFee addJoiningFee(JoiningFee joiningFee) {
		// TODO Auto-generated method stub
		return joiningFeeInt.addJoiningFee(joiningFee);
	}

}
