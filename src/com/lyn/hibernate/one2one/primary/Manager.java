package com.lyn.hibernate.one2one.primary;

public class Manager {
	private Integer id;
	private String name;
	private Department department;
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", department=" + department + "]";
	}
}
