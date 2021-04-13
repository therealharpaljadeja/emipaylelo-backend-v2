package com.emipaylelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emipaylelo.model.JoiningFee;
@Repository
public class JoiningFeeDao implements JoiningFeeInt{
	@PersistenceContext
	EntityManager em;
	
	
	public JoiningFeeDao(){
		
	}
	@Transactional
	public JoiningFee addJoiningFee(JoiningFee joiningFee){
		
		JoiningFee joiningFeePersisted = em.merge(joiningFee);
		
		return joiningFeePersisted;
	}
	
}
