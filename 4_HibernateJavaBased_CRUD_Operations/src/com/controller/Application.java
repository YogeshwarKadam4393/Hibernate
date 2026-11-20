package com.controller;

import java.io.Serializable;

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
												// get Returns Null if that user is not found with ID
												// get supports eger loading
												// get will always give correct Data
		
	  // User user = session.load(User.class, 1); // load method does not return anything if ID not found
													// load throws an ObjectNotFoundException
													// load supports Lazy loading
													// load will give Proxy Data
		
		System.out.println("User Details : "+user);		
		// System.out.println("User Details : "+user.getClass());  // getClass() Method is used to check whether data is correct or not
		tx.commit();
	}
	

	private static void addUserDetails(SessionFactory sf) {
		
		Session session = sf.openSession();
//		Session session1 = sf.openSession();
		
//		Session session2 = sf.getCurrentSession();  // getCurrentSession is used when u want to use the same session at two places
//		Session session3 = sf.getCurrentSession();

		Transaction tx = session.beginTransaction();

		User user = new User();
		user.setUname("Yusuf");
		user.setUcity("Pune");

		//session.persist(user);  // It is similar to save method & it belongs to JPA & Return Type is Void & it Doest not Return Id
		Serializable id = session.save(user);  // Return Type is Serializable & Returns Id 
		System.out.println("User with ID : "+ id + " Saved");
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
