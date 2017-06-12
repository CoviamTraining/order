package com.coviam.ecomm.entity;

public class OrderToShow {
	private int orderId;
	private int orderNo;
	private OrderDetails orderitems;
	private Integer rating;
	private String review;

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
	public OrderDetails getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(OrderDetails orderitems) {
		this.orderitems = orderitems;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "OrderToShow [orderNo=" + orderNo + ", orderitems=" + orderitems + ", rating=" + rating + ", review="
				+ review + "]";
	}
}