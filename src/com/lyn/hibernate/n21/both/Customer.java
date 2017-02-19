package com.lyn.hibernate.n21.both;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer customerId;
	private String name;
	//需要把集合进行初始化，防止空指针异常
	//声明集合类型时要使用接口类型，因为hibernate在获取集合类型时，返回的是hibernate的内置集合类型，而不是javaSE的标准集合实现
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
