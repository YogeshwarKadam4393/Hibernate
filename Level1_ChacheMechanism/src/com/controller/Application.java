package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Address;
import com.util.HibernateUtil;

public class Application {
	
	public static void main(String[] args) {
		
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session1 = sf.openSession();
	Transaction tx = session1.beginTransaction();
	
	Address a1 = session1.get(Address.class, 1);
	Address a2 = session1.get(Address.class, 1);
	Address a3 = session1.get(Address.class, 2);
	Address a4 = session1.get(Address.class, 3);

	Session session2 = sf.openSession();
	
	Address a5 = session2.get(Address.class, 1);
	Address a6 = session2.get(Address.class, 2);
	Address a7 = session2.get(Address.class, 4);

	session1.evict(a1); // evict is used if we want to clear given object
	
	Address a8 = session1.get(Address.class, 1);
	Address a9 = session2.get(Address.class, 2);
	
	session1.clear(); // This is used to clear the chache but the execution will Starts from Main Method
					  // & It Does not clear Data From DB just from cache
	
	Address a10 = session2.get(Address.class, 1);

	tx.commit();
	
		/*
		 * Address address = new Address(); 
		 * address.setAcity("Pune");
		 * address.setAstate("Maharashtra"); 
		 * address.setAcountry("India");
		 * 
		 * session.save(address); 
		 * System.out.println("Address Saved Successfully");
		 */
	
	// session.close(); // This is used to close the session and it prevents data leak
	
	}

}
