package com.coviam.ecomm.ecomm;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class OrderDAOImpl implements OrderDAO {

    @Autowired
//    private ProductDAO productDAO;

    private int getMaxOrderNum() {
        @Query(value = "Select max(o.orderNum) from " + Order.class.getName() + " o ",nativeQuery=true)
        if (value == null) {
            return 0;
        }
        return value;
    }

    @Override
    public void saveOrder(Order order) {
        int orderNum = this.getMaxOrderNum() + 1;
//        Order order = new Order();
//        order.setId(UUID.randomUUID().toString());
//        order.setOrderNum(orderNum);
//        order.setOrderTimetamp(new Timestamp(orderNum));
//        order.setAmount(order.getAmountTotal());

        String customerInfo = order.getCustomerEmail();
      
        Object lines;
		for (OrderDetail line : lines) {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(UUID.randomUUID().toString());
            detail.setOrder(order);
            detail.setorderAmount(line.getorderAmount());
            detail.setPrice(line.getProductInfo().getPrice());
            detail.setQuanity(line.getQuantity());
            String productId = line.getProductInfo().getProductId();
            Product product = this.productDAO.findProduct(productId);
            detail.setProduct(product);
            orderInfo.setOrderNum(orderNum);
        }
    }

    public Order findOrder(int orderId) {
        Order order=new Order();
        info=order.getOrderInfo(orderId);
        if(info=null)
            return null;
    }else{
        return order;
    }

    @Override
    public OrderInfo getOrderInfo(String orderId) {
        Order order = this.findOrder(orderId);
        if (order == null) {
            return null;
        }
        return new OrderInfo(order.getorderId(), order.getOrderTimestamp(), order.getAmount(),
                order.getCustomerEmail());
    }

    @Override
    public List<OrderDetailInfo> listOrderDetailInfos(int orderId) {
        @Query(value = "Select new " + OrderDetailInfo.class.getName() + "(d.id, d.product.code, d.product.name , d.quanity,d.price,d.amount) " + " from " + OrderDetail.class.getName() + " d "+ " where d.order.id = :orderId ")
        value.setParameter("orderId", orderId);
 
        return value.list();
    }

	@Override
	public OrderInfo getOrderInfo(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetailInfo> listOrderDetailInfos(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}