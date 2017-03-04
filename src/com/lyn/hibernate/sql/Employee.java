package com.lyn.hibernate.sql;

public class Employee {
	public Employee() {
		super();
	}
	public Employee(float salary, String email, Department department) {
		super();
		this.salary = salary;
		this.email = email;
		this.department = department;
	}
	
	private Integer id;
	private String name;
	private float salary;
	private String email;
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
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}
