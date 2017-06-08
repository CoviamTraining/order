package com.coviam.ecomm.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.support.ManagedArray;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.coviam.ecomm.entity.Order;
import com.coviam.ecomm.entity.OrderFromUI;
import com.coviam.ecomm.entity.OrderToShow;
import com.coviam.ecomm.service.OrderService;
import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/orders/{email}/", method = RequestMethod.GET)
	public List<OrderToShow> findOrderByuserEmail(@PathVariable("email") String userEmail) {
		return orderService.findOrderByuserEmail(userEmail);
	}

	// dd
	@RequestMapping(value = "/placeorder", method = RequestMethod.POST)
	public String placeOrder(@RequestBody List<OrderFromUI> order)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("order to add : " + order.toString());

		/*
		 * ObjectMapper objectMapper = new ObjectMapper(); List<OrderFromUI>
		 * orderFromUIs = objectMapper.readValue((JsonParser) order, new
		 * TypeReference<List<OrderFromUI>>() { });
		 */

		// Order orderobject = new ObjectMapper().readValue(order, Order.class);
		orderService.placeOrder(order);
		return "Success";
	}
}