package com.coviam.ecomm.service;

import java.util.List;

import com.coviam.ecomm.entity.Order;
import com.coviam.ecomm.entity.OrderFromUI;
import com.coviam.ecomm.entity.OrderToShow;

public interface OrderService {
	public List<OrderToShow> findOrderByuserEmail(String userEmail);
	public List<Order> placeOrder(List<OrderFromUI> order);
	public Order updateOrderStatus(int orderId);
}