package com.coviam.ecomm.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.coviam.ecomm.dao.OrderDao;
import com.coviam.ecomm.entity.Order;

@Service
public class OrderService {
	@Autowired
	@Qualifier("jpaOrder")
	OrderDao orderDao;

	public Collection<Order> getAllOrders() {
		return (Collection<Order>) orderDao.getAllOrders();
	}

	public Order getOrderByID(String userId) {
		return this.orderDao.getOrderByID(userId);
	}

	public String deleteOrderByID(String userId) {
		return this.orderDao.deleteOrderByID(userId);
	}

	public Order addOrder(Order order) {
		return this.orderDao.addOrder(order);
	}

	public String updateOrderById(String userId, Order order) {
		return this.orderDao.updateOrderById(userId, order);
	}
}