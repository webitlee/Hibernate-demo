package com.lyn.hibernate.helloworld;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Test {
	
	public static void main(String[] args){
		//����һ��sessionFactory����
		SessionFactory sf = null;
		//1������Configuration���󣬶�Ӧhibernate�Ļ�����Ϣ�Ͷ���ӳ���ϵ��Ϣ
		Configuration conf = new Configuration().configure();
		//2)����һ��serviceRegistry����hibernate 4.x����ӵĶ���
		//hibernate���κ����úͷ�����Ҫ�ڸö�����ע��������Ч
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(serviceRegistry);
		
		//����һ��session
		Session session = sf.openSession();
		
		//��������
		Transaction transaction = session.beginTransaction();
		
		//ִ�б������
		News news = new News();
		news.setTitle("Java");
		news.setAuthor("Black Lee");
		news.setDate(new Date());
		session.save(news);
		
		//�ύ����
		transaction.commit();
		
		//�ر�session
		session.close();
		
		//�ر�SessionFactory
		sf.close();
	}
}
