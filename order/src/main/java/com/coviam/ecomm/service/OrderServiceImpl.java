package com.coviam.ecomm.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coviam.ecomm.dao.OrderRepository;
import com.coviam.ecomm.entity.Order;

@Component
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository order;

	@Override
	public ArrayList<Order> findOrderByUserEmail(String userEmail) {

		return order.findOrderByUserEmail(userEmail);

	}

	@Override
	public Order addOrder(Order ord) {
		return order.save(ord);
	}

}