package com.controller;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Department;
import com.util.HibernateUtil;

public class Application {
	
	public static void main(String[] args) {
		
		System.out.println("Application Started");
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		// distinct is used to remove duplicate information
		Query query = session.createQuery("select distinct d from Department d join fetch d.listOfEmployee");
		
		List<Department> listOfDepartment = query.getResultList();
		
		for (Department department : listOfDepartment) {
			System.out.println(department);
		}
		
//		Department dep = new Department();
//		dep.setDname("IT");
//		
//		List<Employee> listOfEmployees = new ArrayList<Employee>();
//		
//		Employee e = new Employee();
//		e.setEname("Yogesh");
//		
//		Employee e1 = new Employee();
//		e1.setEname("Ruksar");
//		
//		listOfEmployees.add(e);
//		listOfEmployees.add(e1);
//		
//		dep.setListOfEmployee(listOfEmployees);
//		
//		session.save(dep);
		
		tx.commit();
		
	}

}
