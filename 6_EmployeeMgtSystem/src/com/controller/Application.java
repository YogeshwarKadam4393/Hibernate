package com.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

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

		// Query 1 : For all Employees
		Query query = session.createQuery("from Employee"); // createQuery is used to create a Query
		List<Employee> listOfEmployee = query.getResultList(); // select * from Employee ---> to get all employees
		System.out.println("List of Employees --->");
		System.out.println("------------------------------------");

		for (Employee employee : listOfEmployee) {
			System.out.println(employee);
		}

		System.out.println();
		
		// Query 2 : For all Names
		Query query1 = session.createQuery("select ename from Employee");
		List<String> listOfNames = query1.getResultList();
		System.out.println("List of Names From Employee Class --->");
		System.out.println("------------------------------------");

		for (String names : listOfNames) {
			System.out.println(names);
		}
		
		System.out.println();
		
		// Query 3 : to get name with given specific Id
		Query query2 = session.createQuery("select ename from Employee where id = 3");
		Object name = query2.getSingleResult();
		System.out.println("Name From Employee With Id = 3 --->");
		System.out.println("------------------------------------");
		System.out.println(name);
		
		System.out.println();

		// Query 4 : to get name & salary with given specific Id
		Query query3 = session.createQuery("select ename,esalary from Employee where id = 3");
		Object[] nameAndSalary = (Object[]) query3.getSingleResult();
		System.out.println("Name & Salary From Employee With Id = 3 --->");
		System.out.println("------------------------------------");
		System.out.println(Arrays.toString(nameAndSalary)); // this is used bcz if not used hashcode will return

		System.out.println();

		// Query 5 : to get name & salary using Placeholder
		Query query4 = session.createQuery("select ename,esalary from Employee where id = :inputId");
		query4.setParameter("inputId", 1);
		Object[] nameAndSalary1 = (Object[]) query4.getSingleResult();
		System.out.println("Name & Salary From Employee Using Placeholder--->");
		System.out.println("------------------------------------");
		System.out.println(Arrays.toString(nameAndSalary1)); 
		
		System.out.println();

		// Query 6 : to get all names & salaries using Employee
		Query query5 = session.createQuery("select ename,esalary from Employee");
		List<Object[]> nameAndSalary2 = query5.getResultList();
		System.out.println("All Names & Salaries From Employee--->");
		System.out.println("------------------------------------");
		
		for (Object[] allNamesAndSalaries : nameAndSalary2) {
			System.out.println(Arrays.toString(allNamesAndSalaries));
		}
		
		System.out.println();
		
		// Query 7 : to get COUNT
		Query query6 = session.createQuery("select COUNT(e ) from Employee e");
		Long count = (Long) query6.getSingleResult();
		System.out.println("COUNT From Employees --->");
		System.out.println("------------------------------------");
		System.out.println(count);
		
		
		tx.commit();
		// addEmployeeDetails(sf);

	}

	private static void addEmployeeDetails(SessionFactory sf) {
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Employee emp = new Employee();
		emp.setEname("Sakshi");
		emp.setEdepartment("Java Developer");
		emp.setEsalary(80000);
		emp.setEcity("Mumbai");

		session.save(emp);

		tx.commit();
	}

}
