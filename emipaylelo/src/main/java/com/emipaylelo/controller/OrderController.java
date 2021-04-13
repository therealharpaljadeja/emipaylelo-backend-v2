package com.emipaylelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.emipaylelo.model.Order;
import com.emipaylelo.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {

	@Autowired
	OrderService orderService;
	
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return orderService.addOrder(order);
	}

	public Order viewOrderByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return orderService.viewOrderByOrderId(orderId);
	}
}
