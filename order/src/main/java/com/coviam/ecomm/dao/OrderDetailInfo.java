package com.coviam.ecomm.ecomm;

public class OrderDetailInfo {
	private int orderNum;
	private int productId;
	private String productName;
	private int quanity;
	private int price;
	private int orderAmount;

	public OrderDetailInfo() {

	}

	public OrderDetailInfo(int orderNum, int productId, String productName, int quanity, int price, int orderAmount) {
		this.orderNum = orderNum;
		this.productId = productId;
		this.productName = productName;
		this.quanity = quanity;
		this.price = price;
		this.orderAmount = orderAmount;

	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
}