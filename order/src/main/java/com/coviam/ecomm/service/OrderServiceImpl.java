package com.coviam.ecomm.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.coviam.ecomm.dao.OrderRepository;
import com.coviam.ecomm.entity.Order;
import com.coviam.ecomm.entity.OrderDetails;
import com.coviam.ecomm.entity.OrderFromUI;
import com.coviam.ecomm.entity.OrderToShow;
import com.coviam.ecomm.entity.ProductNameImageRating;

@Component
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	private RestTemplate restTemplate = new RestTemplate();
	private Date date;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@Override
	public List<OrderToShow> findOrderByuserEmail(String userEmail) {
		System.out.println("==========================1");
		List<OrderToShow> orderToShow = new ArrayList<>();
		List<Order> orders = orderRepository.findOrderByuserEmail(userEmail);
		System.out.println("==========================2");

		for (Order order : orders) {
			OrderToShow orderToShowTemp = new OrderToShow();
			orderToShowTemp.setOrderNo(order.getOrderNo());

			OrderDetails orderdDetailTemp = new OrderDetails();
			orderdDetailTemp.setProductPrice(order.getProductPrice());
			orderdDetailTemp.setProductQuantity(order.getOrderQuantity());

			ProductNameImageRating productNameImageRating = restTemplate.getForObject(
					"http://172.16.20.10:8080/getProductNameImageRating/" + order.getProductId(),
					ProductNameImageRating.class);
			String nameimage = restTemplate.getForObject(
					"http://172.16.20.10:8080/getProductNameImageRating/" + order.getProductId(), String.class);

			String merchantName = restTemplate
					.getForObject("http://172.16.20.10:8090/getMerchantName/" + order.getMerchantId(), String.class);

			orderdDetailTemp.setMerchantName(merchantName);
			orderdDetailTemp.setProductImage(productNameImageRating.getImageurl());
			orderdDetailTemp.setProductName(productNameImageRating.getName());
			orderdDetailTemp.setProductRating(productNameImageRating.getRating());
			orderdDetailTemp.setOrderDate(order.getOrderDate());
			orderdDetailTemp.setOrderStatus(order.getOrderStatus());
			orderdDetailTemp.setMerchantId(order.getMerchantId());
			orderdDetailTemp.setProductId(order.getProductId());
			System.out.println(orderdDetailTemp.toString());

			orderToShowTemp.setOrderitems(orderdDetailTemp);
			orderToShow.add(orderToShowTemp);
		}
		return orderToShow;
	}

	@Override
	public List<Order> placeOrder(List<OrderFromUI> ord) {
		List<Order> orderPlace = new ArrayList<>();
		int maxOrderNo = orderRepository.getMaxorderNo() + 1;
		for (OrderFromUI orderFromUI : ord) {
			Order orderTemp = new Order();
			orderTemp.setMerchantId(orderFromUI.getMerchantId());
			orderTemp.setOrderDate(orderFromUI.getOrderDate());
			orderTemp.setOrderNo(maxOrderNo);
			orderTemp.setOrderQuantity(orderFromUI.getOrderQuantity());
			orderTemp.setOrderStatus(orderFromUI.getOrderStatus());
			orderTemp.setProductPrice(orderFromUI.getProductPrice());
			orderTemp.setUserEmail(orderFromUI.getUserEmail());
			orderTemp.setProductId(orderFromUI.getProductId());
			// TODO set date from server date
			date = new Date();
			orderTemp.setOrderDate(dateFormat.format(date));

			orderPlace.add(orderTemp);
			System.out.println("============");
			System.out.println("orders form ui : \n" + orderTemp.toString());
			System.out.println("============");
		}
		return (List<Order>) orderRepository.save(orderPlace);
	}
}