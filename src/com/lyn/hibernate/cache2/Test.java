package com.lyn.hibernate.cache2;




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
		
		Employee emp1 = (Employee) session.get(Employee.class, 10);
		System.out.println(emp1.getName());
		
		transaction.commit();
		session.close();
		session = sf.openSession();
		transaction = session.beginTransaction();
		
		Employee emp2 = (Employee) session.get(Employee.class, 10);
		System.out.println(emp2.getName());
		
		transaction.commit();
		session.close();
		sf.close();
	}
}
