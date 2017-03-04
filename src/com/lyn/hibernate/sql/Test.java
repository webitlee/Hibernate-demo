package com.lyn.hibernate.sql;




import org.hibernate.Query;
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
		
		String sql = "insert department values (?, ?)";
		Query query = session.createSQLQuery(sql);
		query.setInteger(0, 11).setString(1, "后厨部").executeUpdate();
		
		
		transaction.commit();
		session.close();
		sf.close();
	}
}
