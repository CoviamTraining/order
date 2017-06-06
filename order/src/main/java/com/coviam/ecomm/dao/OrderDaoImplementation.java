package com.coviam.ecomm.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.coviam.ecomm.entity.Order;

@Repository
@Qualifier("jpaOrder")
@Transactional
public class OrderDaoImplementation implements OrderDao {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public Collection<Order> getAllOrders() {
		Collection<Order> Orders = (Collection<Order>) entityManager.createQuery("from Order").getResultList();
		return Orders;
	}

	@Override
	public Order getOrderByID(String userId) {
		try {
			Order order = getOrderByUserId(userId);
			return entityManager.find(Order.class, order.getOrderId());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String deleteOrderByID(String userId) {
		Order order = getOrderByUserId(userId);
		try {
			entityManager.remove(order);
			return "Success";
		} catch (Exception e) {
			return "Failed";
		}
	}

	@Override
	public Order addOrder(Order order) {
		try {
			long OrderId = order.getOrderId();
			final String uri = "http://172.16.20.10:8080/getProduct/1";  
		    RestTemplate restTemplate = new RestTemplate();
		    Object product = restTemplate.getForObject(uri, Object.class);
			//List<Product> updatedProducts = new ArrayList<>();
			if (!OrderExists(OrderId)) {
//				List<Product> products = order.getListOfProducts();

	//			for (Product product : products) {
					String pName =  ((Object) product).getName();
					String pDescription = ((Object) product).getDescription();
					double pPrice = ((Object) product).getPrice();

					String hql = "from Product where name=:name and description=:desc and price=:price";
					Product p = (Product) entityManager.createQuery(hql).setParameter("name", pName)
							.setParameter("desc", pDescription).setParameter("price", pPrice).getSingleResult();
					updatedProducts.add(p);
//			//	}
				order.setListOfProducts(updatedProducts);
				entityManager.persist(order); 
				return order;
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String updateOrder(Order order) {
		try {
			long OrderId = order.getOrderId();
			if (OrderExists(OrderId)) {
				entityManager.merge(order);
				return "Done Successfully!";
			} else
				return "Failed to do so!";
		} catch (Exception e) {
			return "Failed to Update!";
		}
	}

	@Override
	public String updateOrderById(String userId, Order order) {
		Order thisOrder = getOrderByUserId(userId);
		if (OrderExists(thisOrder.getOrderId()))
			return updateOrder(order);

		return "Can't Update..Invalid Order..!!";
	}

	private boolean OrderExists(Long orderId) {
		Order order = entityManager.find(Order.class, orderId);

		if (order != null) {
			return true;
		} else {
			return false;
		}
	}

	private Order getOrderByUserId(String userId) {
		String hql = "from Order where userId=:id";
		Order order = (Order) entityManager.createQuery(hql).setParameter("id", userId).getSingleResult();

		return order;
	}
}