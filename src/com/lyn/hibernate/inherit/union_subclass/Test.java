package com.lyn.hibernate.inherit.union_subclass;

import java.util.List;

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
//		Person person1 = new Person();
//		person1.setAge(50);
//		person1.setName("隔壁老王");
//		Student student1 = new Student();
//		student1.setAge(26);
//		student1.setName("Black Lee");
//		student1.setSchool("皇家商业大学");
//		session.save(person1);
//		session.save(student1);
		
		//查询操作
		//查询父类记录只需要查询一张数据表
		//对于子类记录，同样只需要查询一张数据表
//		@SuppressWarnings("unchecked")
//		List<Person> person2 = session.createQuery("FROM Person").list();
//		System.out.println(person2.size());
//		@SuppressWarnings("unchecked")
//		List<Student> student2 = session.createQuery("FROM Student").list();
//		System.out.println(student2.size());
		
		//更新操作
		String hql = "update Person p set p.age = 20";
		session.createQuery(hql).executeUpdate();
		
		transaction.commit();
		session.close();
		sf.close();
		
	}

}
