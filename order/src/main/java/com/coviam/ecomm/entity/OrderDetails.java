package com.coviam.ecomm.entity;

public class OrderDetails {

	private String productName;
	private String productImage;
	private double productRating;
	private String merchantName;
	private double productPrice;
	private int productQuantity;
	private String orderDate;
	private String orderStatus;

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public double getProductRating() {
		return productRating;
	}
	public void setProductRating(double productRating) {
		this.productRating = productRating;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
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

	@Override
	public String toString() {
		return "OrderDetails [productName=" + productName + ", productImage=" + productImage + ", productRating="
				+ productRating + ", merchantName=" + merchantName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ "]";
	}
}