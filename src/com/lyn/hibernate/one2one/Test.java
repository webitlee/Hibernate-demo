package com.lyn.hibernate.one2one;

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
		
		//添加记录
//		Manager manager1 = new Manager();
//		manager1.setName("Black Lee");
//		Department department1 = new Department();
//		department1.setName("技术部");
		//设定关联关系
//		manager1.setDepartmentId(department1);
//		department1.setManagerId(manager1);
//		session.save(manager1);
//		session.save(department1);
		
		//获得对象
		//Manager manager2 = (Manager) session.get(Manager.class, 2);
		//System.out.println(manager2.getName());
		//查询Department对象的连接条件应该是department.id = manager.department_id,而不是department.id=manager.id
		//System.out.println(manager2.getDepartmentId().getName());
		Department department2 = (Department) session.get(Department.class, 2);
		//在查询没有外键一端的对象时，使用的左外连接，一并查询出其关联的对象，并进行初始化。
		System.out.println(department2.getName());
		System.out.println(department2.getManagerId().getName());
		
		
		
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
