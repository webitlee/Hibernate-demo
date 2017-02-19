package com.lyn.hibernate.n21.both;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer customerId;
	private String name;
	//��Ҫ�Ѽ��Ͻ��г�ʼ������ֹ��ָ���쳣
	//������������ʱҪʹ�ýӿ����ͣ���Ϊhibernate�ڻ�ȡ��������ʱ�����ص���hibernate�����ü������ͣ�������javaSE�ı�׼����ʵ��
	private Set<Order> orders = new HashSet<Order>();
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", orders=" + orders + "]";
	}
}
