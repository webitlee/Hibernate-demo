package com.lyn.hibernate.sessionDemo;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
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
		
		
		//News news = (News)session.get(News.class, 1);
		//System.out.println(news);
		
		//news.setTitle("CSS");
		//session.flush();
		
		//News news2 = new News();
		//news2.setAuthor("SUN");
		//news2.setTitle("java");
		//news2.setDate(new Date());
		//session.save(news2);
		
		//News news3 = new News();
		//news3.setAuthor("Oracle");
		//news3.setTitle("html");
		//news3.setDate(new Date());
		//news3.setId(10);
		//session.persist(news3);
		
		//News news4 = (News) session.load(News.class, 2);
		//System.out.println(news4);
		
		//News news5 = (News) session.get(News.class, 1);
		//news5.setAuthor("SUN¹«Ë¾");
		
		//News news6 = new News();
		//news6.setAuthor("bluse");
		//news6.setTitle("PHP");
		//news6.setDate(new Date());
		//session.saveOrUpdate(news6);
		
		//News news7 = new News();
		//news7.setId(5);
		//session.delete(news7);
		
		//News news8 = (News) session.get(News.class, 4);
		//session.delete(news8);
		
		//News news9 = (News) session.get(News.class, 3);
		//News news10 = (News) session.get(News.class, 4);
		//news9.setTitle("Oracle");
		//news10.setTitle("Oracle");
		//session.evict(news10);
		
//		session.doWork(new Work() {
//			
//			@Override
//			public void execute(Connection conn) throws SQLException {
//				System.out.println(conn);
//				
//			}
//		});
		transaction.commit();
		session.close();
		sf.close();
	}
}
