package com.lyn.hibernate.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

import com.lyn.hibernate.hql.Employee;
import com.lyn.hibernate.util.HibernateUtils;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtils.getInstance().getSession();
		Transaction transaction = session.beginTransaction();
		//管理Session
//		EmployeeDao employeeDao = new EmployeeDao();
//		Employee emp = new Employee();
//		employeeDao.save(emp);
//		employeeDao.save(emp);
//		employeeDao.save(emp);
		
		//批处理
		session.doWork(new Work(){
			@Override
			public void execute(Connection arg0) throws SQLException {
				//通过JDBC的原生API进行操作，效率高，速度最快！
			}
		});
		
		transaction.commit();
		System.out.println(session.isOpen());
	}

}
