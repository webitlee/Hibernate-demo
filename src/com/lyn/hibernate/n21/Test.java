package com.lyn.hibernate.n21;

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
		
		Customer customer1 =new Customer();
		customer1.setName("Black Lee");
		Order order1 = new Order();
		order1.setOrderName("乐事薯片");
		Order order2 = new Order();
		order2.setOrderName("德芙巧克力");

		//设定关联关系
		order1.setCustomerId(customer1);
		order2.setCustomerId(customer1);
		//先插入1的一端再插入多的一端,共执行3条insert语句
//		session.save(customer1);
//		session.save(order1);
//		session.save(order2);
		
		//先插入多的一端再出入1的一端，共执行5条语句，3条insert语句，2条update语句
		session.save(order1);
		session.save(order2);
		session.save(customer1);
		
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
