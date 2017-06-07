package com.coviam.ecomm.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public ArrayList<Order> findOrderByUserEmail(@PathVariable("id") String userEmail) {
		return orderService.findOrderByUserEmail(userEmail);
	}

	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public Order addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}
}