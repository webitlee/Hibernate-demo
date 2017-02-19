package com.lyn.hibernate.n21.both;

import java.util.Iterator;

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
		
//		Customer customer1 =new Customer();
//		customer1.setName("Black Lee");
//		Order order1 = new Order();
//		order1.setOrderName("乐事薯片");
//		Order order2 = new Order();
//		order2.setOrderName("德芙巧克力");

		//设定关联关系
//		order1.setCustomerId(customer1);
//		order2.setCustomerId(customer1);
//		customer1.getOrders().add(order1);
//		customer1.getOrders().add(order2);
		//执行save操作，先插入Customer再插入Order,3条insert，2条update
//		session.save(customer1);
//		session.save(order1);
//		session.save(order2);
//		
		//先插入多的一端再出入1的一端，共执行5条语句，3条insert语句，4条update语句
//		session.save(order1);
//		session.save(order2);
//		session.save(customer1);
		
		//查询操作
		//Customer customer2 = (Customer) session.get(Customer.class, 1);
		//System.out.println(customer2.getOrders().size());
		
//		Order order3 = (Order) session.get(Order.class, 1);
//		System.out.println(order3.getCustomerId().getName());
//		System.out.println(order3.getOrderName());
		
		//更新操作
//		Order order4 = (Order) session.get(Order.class, 1);
//		order4.getCustomerId().setName("Lee");
		
//		Customer customer3 = (Customer) session.get(Customer.class, 1);
//		Iterator<Order> it = customer3.getOrders().iterator();
//		while(it.hasNext()){
//			it.next().setOrderName("TT");
//		}
		
		//删除操作
//		Customer customer3 = (Customer) session.get(Customer.class, 1);
//		session.delete(customer3);
		
		Order order5 = (Order) session.get(Order.class, 1);
		session.delete(order5);
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
