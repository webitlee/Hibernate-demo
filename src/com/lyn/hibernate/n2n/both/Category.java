package com.lyn.hibernate.n2n.both;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private Integer id;
	private String name;
	private Set<Items> items = new HashSet<Items>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Items> getItems() {
		return items;
	}
	public void setItems(Set<Items> items) {
		this.items = items;
	}
}
