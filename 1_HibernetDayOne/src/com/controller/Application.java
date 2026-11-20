package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Students;



public class Application {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure("hibernet.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Students st = new Students();
		st.setSid(101);
		st.setSname("Yogesh");
		st.setScity("Pune");
		
		session.save(st);
		
		session.beginTransaction().commit();
		
		System.out.println("Student Saved Successfully");
	}
	
}
