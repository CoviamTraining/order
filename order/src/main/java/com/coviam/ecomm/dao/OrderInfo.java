package com.coviam.ecomm.ecomm;

import java.sql.Timestamp;
import java.util.List;

public class OrderInfo {
    private int orderNum;
    private int orderAmount;
    private Timestamp orderTimestamp;
    private String customerEmail;

    private List<OrderDetailInfo> details;

    public OrderInfo() {
    }

    public OrderInfo(int orderNum, Timestamp orderTimestamp, int orderAmount, String customerEmail) {
        this.orderNum = orderNum;
        this.orderTimestamp = orderTimestamp;
        this.orderNum = orderNum;
        this.orderAmount = orderAmount;
        this.customerEmail = customerEmail;

    }

    public int getOrderNum() {
        return orderNum;
    }
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getOrderAmount() {
        return orderAmount;
    }
    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Timestamp getOrderTimestamp() {
        return orderTimestamp;
    }
    public void setOrderTimestamp(Timestamp orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<OrderDetailInfo> getDetails() {
        return details;
    }
    public void setDetails(List<OrderDetailInfo> details) {
        this.details = details;
    }
}