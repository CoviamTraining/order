package com.coviam.ecomm.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.coviam.ecomm.dao.OrderRepository;
import com.coviam.ecomm.entity.Order;
import com.coviam.ecomm.entity.OrderDetails;
import com.coviam.ecomm.entity.OrderFromUI;
import com.coviam.ecomm.entity.OrderToShow;
import com.coviam.ecomm.entity.ProductNameImageRating;
import com.coviam.ecomm.entity.RatingReview;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	private RestTemplate restTemplate = new RestTemplate();
	private Date date;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@Value("${productUri}")
	private String productUri;
	@Value("${merchantUri}")
	private String merchantUri;
	@Value("${inventoryUri}")
	private String inventoryUri;

	@Override
	public List<OrderToShow> findOrderByuserEmail(String userEmail) {
		List<OrderToShow> orderToShow = new ArrayList<>();
		List<Order> orders = orderRepository.findOrderByuserEmail(userEmail);

		for (Order order : orders) {
			OrderToShow orderToShowTemp = new OrderToShow();
			orderToShowTemp.setOrderId(order.getOrderId());
			orderToShowTemp.setOrderNo(order.getOrderNo());

			OrderDetails orderdDetailTemp = new OrderDetails();
			orderdDetailTemp.setProductPrice(order.getProductPrice());
			orderdDetailTemp.setProductQuantity(order.getOrderQuantity());

			ProductNameImageRating productNameImageRating = restTemplate.getForObject(
					productUri + "getProductNameImageRating/" + order.getProductId(), ProductNameImageRating.class);
			String nameimage = restTemplate
					.getForObject(productUri + "getProductNameImageRating/" + order.getProductId(), String.class);

			String merchantName = restTemplate.getForObject(merchantUri + "getMerchantName/" + order.getMerchantId(),
					String.class);

			orderdDetailTemp.setMerchantName(merchantName);
			orderdDetailTemp.setProductImage(productNameImageRating.getImageurl());
			orderdDetailTemp.setProductName(productNameImageRating.getName());
			orderdDetailTemp.setProductRating(productNameImageRating.getRating());
			orderdDetailTemp.setOrderDate(order.getOrderDate());
			orderdDetailTemp.setOrderStatus(order.getOrderStatus());
			orderdDetailTemp.setMerchantId(order.getMerchantId());
			orderdDetailTemp.setProductId(order.getProductId());
			orderdDetailTemp.setOrderId(order.getOrderId());

			orderToShowTemp.setOrderitems(orderdDetailTemp);
			System.out.println("====+++=+=+==+==+++++\n\n" + inventoryUri + "getProductRatingReview/"
					+ order.getProductId() + "/" + order.getMerchantId() + "/" + order.getOrderQuantity() + "/");
			String ratingReviewString = restTemplate.getForObject(inventoryUri + "getProductRatingReview/"
					+ order.getProductId() + "/" + order.getMerchantId() + "/" + order.getUserEmail() + "/",
					String.class);
			ObjectMapper objectMapper = new ObjectMapper();

			RatingReview ratingReview = null;
			try {
				ratingReview = objectMapper.readValue(ratingReviewString, RatingReview.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (ratingReview == null) {
				orderToShowTemp.setRating(null);
				orderToShowTemp.setReview(null);
			} else {
				orderToShowTemp.setRating(ratingReview.getRating());
				orderToShowTemp.setReview(ratingReview.getReview());
			}
			orderToShow.add(orderToShowTemp);
			System.out.println("OB=====\n" + orderToShow.toString() + "\n\n");
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
			date = new Date();
			orderTemp.setOrderDate(dateFormat.format(date));
			orderPlace.add(orderTemp);
			System.out.println("============");
			System.out.println("Order From UI:: \n" + orderTemp.toString());
			System.out.println("============");
		}
		return (List<Order>) orderRepository.save(orderPlace);
	}

	public Order updateOrderStatus(int orderId) {
		Order order = orderRepository.findOne(orderId);
		order.setOrderStatus("Cancelled");
		System.out.println("====+++=+=+==+==+++++\n\n" + inventoryUri + "rollbackUpdatedStock/" + order.getProductId()
				+ "/" + order.getMerchantId() + "/" + order.getOrderQuantity() + "/");
		String cancelOrder = restTemplate.getForObject(inventoryUri + "rollbackUpdatedStock" + "AndSoldUpdate/"
				+ order.getProductId() + "/" + order.getMerchantId() + "/" + order.getOrderQuantity(), String.class);
		return orderRepository.save(order);
	}
}