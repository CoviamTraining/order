package com.coviam.ecomm.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.coviam.ecomm.entity.OrderFromUI;
import com.coviam.ecomm.entity.OrderToShow;
import com.coviam.ecomm.service.OrderService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/orders/{email}/", method = RequestMethod.GET)
	public List<OrderToShow> findOrderByuserEmail(@PathVariable("email") String userEmail) {
		return orderService.findOrderByuserEmail(userEmail);
	}

	@RequestMapping(value = "/placeorder", method = RequestMethod.POST)
	public String placeOrder(@RequestBody List<OrderFromUI> order)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Order To Add:: " + order.toString());
		orderService.placeOrder(order);
		return "Success";
	}

	@RequestMapping(value = "/updateOrder/{orderId}")
	public String updateOrder(@PathVariable int orderId) {
		orderService.updateOrderStatus(orderId);
		return "Cancelled";
	}
}