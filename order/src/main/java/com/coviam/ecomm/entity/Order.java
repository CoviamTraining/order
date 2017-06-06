package com.coviam.ecomm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "eorder")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "orderSeq", sequenceName = "Order_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSeq")
	
	private long orderId;
	private String userId;
	private double totalCost;
	private String orderDate;
	private String orderDetails;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "ORDER_PRODUCT", joinColumns = { @JoinColumn(name = "orderId") }, inverseJoinColumns = {
//			@JoinColumn(name = "productId") })
//	List<Product> listOfProducts = new ArrayList<Product>();

	public Order() {
	}

//	public Order(long orderId, String userId, double totalCost, String orderDate, String orderDetails,
//			List<Product> listOfProducts) {
//		super();
//		this.orderId = orderId;
//		this.userId = userId;
//		this.totalCost = totalCost;
//		this.orderDate = orderDate;
//		this.orderDetails = orderDetails;
//		this.listOfProducts = listOfProducts;
//	}

	public Order(long orderId, String userId, double totalCost, String orderDate, String orderDetails) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
		this.orderDetails = orderDetails;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

//	public List<Product> getListOfProducts() {
//		return listOfProducts;
//	}
//
//	public void setListOfProducts(List<Product> listOfProducts) {
//		this.listOfProducts = listOfProducts;
//	}
}