package com.lyn.hibernate.qbc;




import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
		//QBC查询
		//创建一个Criteria对象
		//Criteria criteria = session.createCriteria(Employee.class);
		//2.添加查询条件，在QBC中查询条件使用Criteria来表示
		//Criteria可以通过Restrictions的静态方法得到
		//criteria.add(Restrictions.eq("email", "d.163.com"));
		//criteria.add(Restrictions.gt("salary", 8000f));
		//执行查询
		//Employee emp = (Employee) criteria.uniqueResult();
		//System.out.println(emp);
		
		//AND:使用Conjunction表示
		//Conjunction本身就是一个Criterion对象
//		Criteria criteria = session.createCriteria(Employee.class);
//		Conjunction conjunction = Restrictions.conjunction();
//		conjunction.add(Restrictions.like("name", "e", MatchMode.ANYWHERE));
//		Department department = new Department();
//		department.setId(6);
//		conjunction.add(Restrictions.eq("department", department));
//		criteria.add(conjunction);
//		@SuppressWarnings("unchecked")
//		List<Employee> list = criteria.list();
//		System.out.println(list);
		
		//OR条件查询
//		Criteria criteria = session.createCriteria(Department.class);
//		Disjunction disjunction = Restrictions.disjunction();
//		disjunction.add(Restrictions.like("name", "术", MatchMode.ANYWHERE));
//		disjunction.add(Restrictions.idEq(2));
//		criteria.add(disjunction);
//		@SuppressWarnings("unchecked")
//		List<Department> dept = criteria.list();
//		System.out.println(dept);
		
		//统计查询:使用Projection表示
//		Criteria criteria = session.createCriteria(Employee.class);
//		criteria.setProjection(Projections.min("salary"));
//		System.out.println(criteria.uniqueResult());
		
		//排序查询
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.addOrder(Order.asc("salary"));
		criteria.addOrder(Order.desc("email"));
		//添加分页
		criteria.setFirstResult(2).setMaxResults(9);
		@SuppressWarnings("unchecked")
		List<Employee> list = criteria.list();
		System.out.println(list);
		
		transaction.commit();
		session.close();
		sf.close();
	}
}
