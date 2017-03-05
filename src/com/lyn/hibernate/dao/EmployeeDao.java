package com.lyn.hibernate.dao;

import org.hibernate.Session;

import com.lyn.hibernate.hql.Employee;
import com.lyn.hibernate.util.HibernateUtils;

public class EmployeeDao {
	public void save(Employee emp){
		Session session = HibernateUtils.getInstance().getSession();
		System.out.println(session.hashCode());
		session.save(emp);
	}
}
