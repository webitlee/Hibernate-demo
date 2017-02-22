package com.lyn.hibernate.one2one.primary;

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
		//Department department1 = new Department();
		//department1.setName("������");
		//Manager manager1 = new Manager();
		//manager1.setName("Black Lee");
		//department1.setManager(manager1);
		//manager1.setDepartment(department1);
		//�Ȳ�����һ����������������update��䣬��Ϊdepartment��¼������������manager��¼�������������ܻ��Ȳ���manger��¼
		//session.save(department1);
		//session.save(manager1);
		
		//��ѯ����
		Department department2 = (Department) session.get(Department.class, 1);
		System.out.println(department2.getName());
		System.out.println(department2.getManager().getName());
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
