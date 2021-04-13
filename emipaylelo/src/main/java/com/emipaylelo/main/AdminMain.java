package com.emipaylelo.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.emipaylelo.dao.AdminDao;
import com.emipaylelo.model.Admin;

public class AdminMain {
	public static void main(String[] args){
		
		EntityManager em;
		EntityManagerFactory emf;
		EntityTransaction tx;
		
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx=em.getTransaction();
		
		Admin admin = new Admin();
		admin.setEmailId("admin@emipaylelo.com");
		admin.setPassword("emipaylelo");
		
		tx.begin();
		em.merge(admin);
		tx.commit();
	}
	
	
}
