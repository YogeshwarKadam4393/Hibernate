package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.entity.User;
import com.util.HibernateUtil;


public class Application {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		// addUserDetails(sf);
		// updateUserDetails(sf);
		 getUserDetails(sf);	
		// deleteUserDetails(sf);
	}

	private static void deleteUserDetails(SessionFactory sf) {
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 4);
		session.delete(user);  // delete is used to delete data of given id
		
		tx.commit();
		System.out.println("User Deleted Successfully");
	}

	private static void getUserDetails(SessionFactory sf) {
		
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 1); // get method is used to get the information from that object
		System.out.println(user);
		
		tx.commit();
		System.out.println("User Details");
	}

	private static void addUserDetails(SessionFactory sf) {
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		User user = new User();
		user.setUname("Sumit");
		user.setUcity("Pune");

		session.save(user);

		tx.commit();

		System.out.println("User Details Saved Successfully");
	}

	private static void updateUserDetails(SessionFactory sf) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		User user = session.get(User.class, 3);
		user.setUname("Omkar");
		user.setUcity("Mumbai");

		// session.update(user); //update is used to update the user details from database
		
		session.saveOrUpdate(user); // if data is not present then save will save that info and if already exist
									// then update will override that info and put updated info

		tx.commit();
		System.out.println("User Updated Successfully");
	}
}
