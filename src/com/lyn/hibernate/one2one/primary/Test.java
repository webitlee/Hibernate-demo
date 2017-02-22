package com.lyn.hibernate.one2one.primary;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Test {

	public static void main(String[] args) {
		SessionFactory sf = null;
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(serviceRegistry);
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		//插入操作
		//Department department1 = new Department();
		//department1.setName("技术部");
		//Manager manager1 = new Manager();
		//manager1.setName("Black Lee");
		//department1.setManager(manager1);
		//manager1.setDepartment(department1);
		//先插入哪一个都不会产生多余的update语句，因为department记录的主键依赖于manager记录的主键，所以总会先插入manger记录
		//session.save(department1);
		//session.save(manager1);
		
		//查询操作
		Department department2 = (Department) session.get(Department.class, 1);
		System.out.println(department2.getName());
		System.out.println(department2.getManager().getName());
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
