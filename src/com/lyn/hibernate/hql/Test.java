package com.lyn.hibernate.hql;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

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
		//������λ��
		//1.����Query����
//		String hql = "from Employee e where e.salary > ? and e.email like ?";
//		Query query = session.createQuery(hql);
		//2.�󶨲���
//		query.setFloat(0, 5000).setString(1, "%c%");
		//ִ�в�ѯ
//		List<Employee> employee = query.list();
//		System.out.println(employee.size());
		
		//����������
//		String hql = "from Employee e where e.id > :id and e.salary > :salary";
//		Query query = session.createQuery(hql);
//		query.setInteger("id", 9).setFloat("salary", 8000);
//		List<Employee> emp = query.list();
//		System.out.println(emp.size());
		
		//setFirstResult
//		String hql = "from Employee";
//		Query query = session.createQuery(hql);
//		int pageNo = 3;
//		int pageSize = 3;
//		@SuppressWarnings("unchecked")
//		List<Employee> employee = query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
//		System.out.println(employee);
		
		//��ӳ���ļ��ж���������ѯ���
//		Query query = session.getNamedQuery("salary");
//		query.setFloat("minSal", 3000).setFloat("maxSal", 8000);
//		@SuppressWarnings("unchecked")
//		List<Employee> emp = query.list();
//		System.out.println(emp);
		
		//ͶӰ��ѯ
//		String hql = "select new Employee(e.salary, e.email, e.department) from Employee e where e.department = :department";
//		Query query = session.createQuery(hql);
//		Department department = new Department();
//		department.setId(5);
//		@SuppressWarnings("unchecked")
//		List<Employee> result = query.setEntity("department", department).list();
//		for(Employee emp : result){
//			System.out.println(emp.getId() + ", " + emp.getEmail() + ", " + emp.getDepartment());
//		}
		
		//�����ѯ
//		String hql = "select min(e.salary), max(e.salary) from Employee e group by e.department having min(e.salary) > :minSal";
//		Query query = session.createQuery(hql);
//		query.setFloat("minSal", 5000);
//		@SuppressWarnings("unchecked")
//		List<Object[]> list = query.list();
//		for(Object[] obj : list){
//			System.out.println(Arrays.asList(obj));
//		}
		//迫切左外连接
		//String hql = "from Department d left join fetch d.employee";
		//去重复
		//String hql = "select distinct d from Department d left join fetch d.employee";
		//Query query = session.createQuery(hql);
		//@SuppressWarnings("unchecked")
		//List<Department> dept = query.list();
		//去重复
		//dept = new ArrayList<Department>(new LinkedHashSet<Department>(dept));
		//for(Department d : dept){
		//	System.out.println(d);
		//}
		
		//左外连接
//		String hql = "from Department d left join d.employee";
//		Query query = session.createQuery(hql);
//		@SuppressWarnings("unchecked")
//		List<Object[]> list = query.list();
//		for(Object[] d : list){
//			System.out.println(Arrays.asList(d));
//		}
		//仅查询Department对象
		String hql = "select distinct d from Department d left join d.employee";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Department> dept = query.list();
		for(Department d : dept){
			System.out.println(d);
		}

		
		transaction.commit();
		session.close();
		sf.close();
	}
}
