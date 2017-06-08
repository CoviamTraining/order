package com.coviam.ecomm.entity;

import javax.persistence.Column;

public class OrderFromUI {
	private int productId;
	private int merchantId;
	private String userEmail;
	private int orderQuantity;
	private String orderDate;
	private String orderStatus;
	private double productPrice;

	public OrderFromUI() {
		super();
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
		return "OrderFromUI [productId=" + productId + ", merchantId=" + merchantId + ", userEmail=" + userEmail
				+ ", orderQuantity=" + orderQuantity + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", productPrice=" + productPrice + "]";
	}

}
