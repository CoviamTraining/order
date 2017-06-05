package com.coviam.ecomm.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.coviam.ecomm.entity.Order;
import com.coviam.ecomm.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public Collection<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public Order getOrderByID(@PathVariable String id) {
		return this.orderService.getOrderByID(id);
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
	public String deleteOrderByID(@PathVariable String id) {
		return this.orderService.deleteOrderByID(id);
	}

	@RequestMapping(value = "/orders", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Order addOrder(@RequestBody Order order) {
		return this.orderService.addOrder(order);
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateOrderById(@PathVariable String id, @RequestBody Order order) {
		return this.orderService.updateOrderById(id, order);
	}
}