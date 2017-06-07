package com.coviam.ecomm.controller;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.coviam.ecomm.entity.Order;
import com.coviam.ecomm.service.OrderService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/orders/{email}/", method = RequestMethod.GET)
	public ArrayList<Order> findOrderByuserEmail(@PathVariable("email") String userEmail) {
		return orderService.findOrderByuserEmail(userEmail);
		}
	
	@RequestMapping(value = "/placeorder", method = RequestMethod.POST)
	public Order placeOrder(@RequestParam(value = "placeorder") String order)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("order to add : " + order.toString());
		Order orderobject = new ObjectMapper().readValue(order, Order.class);
		return orderService.placeOrder(orderobject);
		}
	}