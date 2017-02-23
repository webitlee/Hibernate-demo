package com.lyn.hibernate.n2n;

import java.util.Iterator;

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
//		Category category1 = new Category();
//		category1.setName("后端");
//		Category category2 = new Category();
//		category2.setName("编程");
//		Items items1 = new Items();
//		items1.setName("java");
//		Items items2 = new Items();
//		items2.setName("php");
		//映射关联关系
//		category1.getItems().add(items1);
//		category1.getItems().add(items2);
//		category2.getItems().add(items1);
//		category2.getItems().add(items2);
//		session.save(category1);
//		session.save(category2);
//		session.save(items1);
//		session.save(items2);
		
		//查询操作
		Category category3 = (Category) session.get(Category.class, 1);
		System.out.println(category3.getName());
		Iterator<Items> it = category3.getItems().iterator();
		while(it.hasNext()){
			String name = it.next().getName();
			System.out.println(name);
		}
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
