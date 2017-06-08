package com.coviam.ecomm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	@Column(name = "orderno")
	private int orderNo;
	@Column(name = "ProductId")
	private int productId;
	@Column(name = "MerchantId")
	private int merchantId;
	@Column(name = "UserEmail")
	private String userEmail;
	@Column(name = "OrderQuantity")
	private int orderQuantity;
	@Column(name = "OrderDate")
	private String orderDate;
	@Column(name = "OrderStatus")
	private String orderStatus;
	@Column(name = "ProductPrice")
	private double productPrice;

	public Order() {
	}

	public Order(int orderId, int orderNo, int productId, int merchantId, String userEmail, int orderQuantity,
			String orderDate, String orderStatus, double productPrice) {
		this.orderId = orderId;
		this.orderNo = orderNo;
		this.productId = productId;
		this.merchantId = merchantId;
		this.userEmail = userEmail;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.productPrice = productPrice;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderno=" + orderNo + ", productId=" + productId + ", merchantId="
				+ merchantId + ", userEmail=" + userEmail + ", orderQuantity=" + orderQuantity + ", orderDate="
				+ orderDate + ", orderStatus=" + orderStatus + ", productPrice=" + productPrice + "]";
	}
}