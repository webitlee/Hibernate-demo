package com.lyn.hibernate.one2one;

public class Manager {
	private Integer id;
	private String name;
	private Department DepartmentId;
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
	public Department getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(Department departmentId) {
		DepartmentId = departmentId;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", DepartmentId=" + DepartmentId + "]";
	}
}
