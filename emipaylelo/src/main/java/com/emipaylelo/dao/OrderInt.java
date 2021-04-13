package com.emipaylelo.dao;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.Order;

@Component
public interface OrderInt {

	public Order addOrder(Order order);
	
	public Order viewOrderByOrderId(int orderId);
	
}
