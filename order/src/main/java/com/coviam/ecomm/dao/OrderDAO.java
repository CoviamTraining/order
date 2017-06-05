package com.coviam.ecomm.ecomm;

import java.util.List;

public interface OrderDAO {
	public void saveOrder(Order order);
	public OrderInfo getOrderInfo(int orderId);
	public List<OrderDetailInfo> listOrderDetailInfos(int orderId);
}