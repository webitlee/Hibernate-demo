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
		//创建一个sessionFactory对象
		SessionFactory sf = null;
		//1）创建Configuration对象，对应hibernate的基本信息和对象映射关系信息
		Configuration conf = new Configuration().configure();
		//2)创建一个serviceRegistry对象，hibernate 4.x新添加的对象
		//hibernate的任何配置和服务都需要在该对象中注册后才能有效
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(serviceRegistry);
		
		//创建一个session
		Session session = sf.openSession();
		
		//开启事务
		Transaction transaction = session.beginTransaction();
		
		//执行保存操作
		News news = new News();
		news.setTitle("Java");
		news.setAuthor("Black Lee");
		news.setDate(new Date());
		session.save(news);
		
		//提交事务
		transaction.commit();
		
		//关闭session
		session.close();
		
		//关闭SessionFactory
		sf.close();
	}
}
