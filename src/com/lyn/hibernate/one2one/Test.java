package com.lyn.hibernate.one2one;

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
		
		//添加记录
		Manager manager1 = new Manager();
		manager1.setName("Black Lee");
		Department department1 = new Department();
		department1.setName("技术部");
		//设定关联关系
		manager1.setDepartmentId(department1);
		department1.setManagerId(manager1);
		session.save(manager1);
		session.save(department1);
		
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
