package com.lyn.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {
	private HibernateUtils(){};
	private static HibernateUtils instance = new HibernateUtils();
	public static HibernateUtils getInstance(){
		return instance;
	}
	private SessionFactory sf = null;
	public SessionFactory getSessionFactory(){
		if(sf == null){
			Configuration conf = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
			sf = conf.buildSessionFactory(serviceRegistry);
		}
		return sf;
	}
	public Session getSession(){
		return getSessionFactory().getCurrentSession();
	}
}
