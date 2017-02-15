package com.lyn.hibernate.n21;

public class Order {
	private Integer orderId;
	private Customer customerId;
	private String orderName;
	public Integer getOrderId() {
		return orderId;
	}
	public Customer getCustomerId() {
		return customerId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
}
