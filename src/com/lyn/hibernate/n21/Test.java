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
		order1.setOrderName("������Ƭ");
		Order order2 = new Order();
		order2.setOrderName("��ܽ�ɿ���");

		//�趨������ϵ
		order1.setCustomerId(customer1);
		order2.setCustomerId(customer1);
		//�Ȳ���1��һ���ٲ�����һ��,��ִ��3��insert���
//		session.save(customer1);
//		session.save(order1);
//		session.save(order2);
		
		//�Ȳ�����һ���ٳ���1��һ�ˣ���ִ��5����䣬3��insert��䣬2��update���
		session.save(order1);
		session.save(order2);
		session.save(customer1);
		
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
