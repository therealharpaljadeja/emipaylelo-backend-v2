package com.emipaylelo.service;

import org.springframework.stereotype.Component;

import com.emipaylelo.model.Order;
@Component
public interface OrderService {

    public Order addOrder(Order order);
	
	public Order viewOrderByOrderId(int orderId);
}
