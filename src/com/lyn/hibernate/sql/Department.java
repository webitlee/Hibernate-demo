package com.lyn.hibernate.sql;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private Integer id;
	private String name;
	private Set<Employee> employee = new HashSet<Employee>();
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
	public Set<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employee=" + employee + "]";
	}
}
