package com.coviam.ecomm.service;

import java.util.ArrayList;

import com.coviam.ecomm.entity.Order;

public interface OrderService {

	public ArrayList<Order> findOrderByUserEmail(String userEmail);

	public Order addOrder(Order order);
}