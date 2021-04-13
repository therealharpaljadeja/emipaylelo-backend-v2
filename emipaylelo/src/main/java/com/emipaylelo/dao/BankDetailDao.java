package com.emipaylelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emipaylelo.model.BankDetail;
@Repository
public class BankDetailDao implements BankDetailInt{
	@PersistenceContext
	EntityManager em;
	
	
	public BankDetailDao(){
		
	}
	@Transactional
	public BankDetail addBankDetail(BankDetail bankDetail){
		
		BankDetail bankDetailPersisted = em.merge(bankDetail);
		
		return bankDetailPersisted;
	}
	
}
