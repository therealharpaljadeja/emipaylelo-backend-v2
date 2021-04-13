package com.emipaylelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emipaylelo.model.Order;
@Repository
public class OrderDao implements OrderInt{
	@PersistenceContext
	EntityManager em;
	
	
	public OrderDao(){
	
	}
	@Transactional
	public Order addOrder(Order order){
		
		Order orderPersisted = em.merge(order);
		
		return orderPersisted;
	}
	@Transactional
	public Order viewOrderByOrderId(int orderId){
		return em.find(Order.class, orderId);
	}
	
	
}
