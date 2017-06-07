package com.coviam.ecomm.service;

import java.util.ArrayList;
import com.coviam.ecomm.entity.Order;

public interface OrderService {
	public ArrayList<Order> findOrderByuserEmail(String userEmail);
	public Order placeOrder(Order order);
}