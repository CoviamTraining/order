package com.coviam.ecomm.entity;

//import java.util.List;

public class OrderToShow {
	private int orderNo;
	private OrderDetails orderitems;

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

	@Override
	public String toString() {
		return "OrderToShow [orderNo=" + orderNo + ", orderitems=" + orderitems + "]";
	}
}