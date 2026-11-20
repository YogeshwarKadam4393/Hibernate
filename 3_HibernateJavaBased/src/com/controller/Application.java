package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Employee;
import com.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionfactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Employee emp = new Employee();
		emp.setEname("Yogesh");
		emp.setEaddress("Pcmc");

		session.save(emp);

		tx.commit();

	}

}
