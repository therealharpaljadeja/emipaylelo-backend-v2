package com.emipaylelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.emipaylelo.dao.OrderInt;
import com.emipaylelo.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderInt orderInt;
	
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return orderInt.addOrder(order);
	}

	public Order viewOrderByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return orderInt.viewOrderByOrderId(orderId);
	}

}
