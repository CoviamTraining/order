package com.coviam.ecomm.dao;

import java.util.Collection;
import com.coviam.ecomm.entity.Order;

public interface OrderDao {
	public Collection<Order> getAllOrders();
	public Order getOrderByID(String userId);
	public String deleteOrderByID(String userId);
	public Order addOrder(Order order);
	public String updateOrderById(String userId, Order order);
}