package com.lyn.hibernate.n2n.both;

import java.util.HashSet;
import java.util.Set;


public class Items {
	private Integer id;
	private String name;
	private Set<Category> category = new HashSet<Category>();
	public Set<Category> getCategory() {
		return category;
	}
	public void setCategory(Set<Category> category) {
		this.category = category;
	}
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
}
