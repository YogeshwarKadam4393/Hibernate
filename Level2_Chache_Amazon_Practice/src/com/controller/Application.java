package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Order;
import com.entity.Payment;
import com.entity.Product;
import com.util.HibernateUtil;

public class Application {
	
	public static void main(String[] args) {
		
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session1 = sf.openSession();
	Session session2 = sf.openSession();
	
	Transaction tx = session1.beginTransaction();
	
	//addDetails(session1);
	
	Product p1 = session1.get(Product.class, 1); // 1
	Order o1 = session1.get(Order.class, 101); // 2
	Payment pay1 = session1.get(Payment.class, 201); // 3
	
	Product p2 = session1.get(Product.class, 1); 
	Order o2 = session1.get(Order.class, 102); // 4
	Payment pay2 = session1.get(Payment.class, 202); // 5
	
	session1.clear();
	
	Product p3 = session1.get(Product.class, 1); 
	Order o3 = session1.get(Order.class, 102); 
	Payment pay3 = session1.get(Payment.class, 202); 
	
	Product p4 = session2.get(Product.class, 2); // 6
	Order o4 = session2.get(Order.class, 101); 
	Payment pay4 = session2.get(Payment.class, 201); 
	
	session2.clear();
	
	Product p5 = session2.get(Product.class, 1); 
	Order o5 = session2.get(Order.class, 102); 
	Payment pay5 = session2.get(Payment.class, 201); 
	
	sf.getCache().evict(Product.class, 1); // This Method is used to clear Session Factory's Cache
	sf.getCache().evict(Order.class, 101);
	sf.getCache().evict(Payment.class, 201);
	
	session1.clear();
	session2.clear();
	
	Product p6 = session2.get(Product.class, 1);  // 7
	Order o6 = session2.get(Order.class, 101); // 8
	Payment pay6 = session1.get(Payment.class, 201); // 9
	
	sf.getCache().evictAll(); // This Method is used to clear Whole Session Factory but one copy is Stored in Session
	
	Product p7 = session2.get(Product.class, 1); 
	Order o7 = session2.get(Order.class, 101); 
	Payment pay7 = session1.get(Payment.class, 201); 
	
	tx.commit();
	
	}

	private static void addDetails(Session session1) {
		Product p = new Product();
		p.setPname("IPhone 17 Pro");
		p.setPprice(130000.0);
		
		Order o = new Order();
		o.setOid(102);
		o.setCname("Sakshi");
		o.setOquantity(1);
		
		Payment payment = new Payment();
		payment.setTransactionid(202);
		payment.setPaymentMethod("UPI");
		payment.setAmmount(130000.0);

		session1.save(p);
		session1.save(o);
		session1.save(payment);
	}


}
