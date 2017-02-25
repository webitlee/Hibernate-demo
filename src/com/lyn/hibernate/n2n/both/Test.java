package com.lyn.hibernate.n2n.both;

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
		
		//�������
//		Category category1 = new Category();
//		category1.setName("���Ӳ�Ʒ");
//		Category category2 = new Category();
//		category2.setName("����");
//		Items item1 = new Items();
//		item1.setName("���ձʼǱ�����");
//		Items item2 = new Items();
//		item2.setName("��������");
//		category1.getItems().add(item1);
//		category1.getItems().add(item2);
//		category2.getItems().add(item1);
//		category2.getItems().add(item2);
//		item1.getCategory().add(category1);
//		item1.getCategory().add(category2);
//		item2.getCategory().add(category2);
//		item2.getCategory().add(category1);
//		session.save(category1);
//		session.save(category2);
//		session.save(item1);
//		session.save(item2);
		
		//��ѯ����
		Category category3 = (Category) session.get(Category.class, 1);
		System.out.println(category3.getName());
		Iterator<Items> it = category3.getItems().iterator();
		while(it.hasNext()){
			System.out.println(it.next().getName());
		}
		System.out.println("�����ָ���------");
		Items item3 = (Items) session.get(Items.class, 1);
		System.out.println(item3.getName());
		Iterator<Category> it2 = item3.getCategory().iterator();
		while(it2.hasNext()){
			System.out.println(it2.next().getName());
		}
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
