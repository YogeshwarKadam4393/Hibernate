package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Department;
import com.entity.Employee;
import com.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {

		System.out.println("Application Started");

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

//		Transaction tx = session.beginTransaction();

		Department dep = new Department();
//		dep.setDname("IT");
//		
//		List<Employee> listOfEmployees = new ArrayList<Employee>();
//		
//		Employee e = new Employee();
//		e.setEname("Yogesh");
//		
//		Employee e1 = new Employee();
//		e1.setEname("Sujit");
//		
//		listOfEmployees.add(e);
//		listOfEmployees.add(e1);
//		
//		dep.setListOfEmployee(listOfEmployees);
//		
//		session.save(dep);

		Department department = session.get(Department.class, 1);

		session.close();

		department.setDname("HR");

		Session session1 = sf.openSession();

		Transaction tx = session1.beginTransaction();
		session1.merge(department);

		tx.commit();

	}

}
