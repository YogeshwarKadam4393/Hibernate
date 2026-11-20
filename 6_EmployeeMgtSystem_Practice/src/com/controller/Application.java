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
		
		//addEmployeeDetails(sf);

		// Query 1 :Display all employee names.
		Query query1 = session.createQuery("from Employee");
		List<Employee> allEmps = query1.getResultList();
		
		for (Employee employee : allEmps) {
			System.out.println(employee);
		}
		
		// Query 2 :Display employee names and salary only.
		Query query2 = session.createQuery("select ename , esalary from Employee ");
		List<Object[]> nameAndSalary = query2.getResultList();
		
		for (Object[] objects : nameAndSalary) {
			System.out.println(Arrays.toString(objects));
		}
		
		// Query 3 :Display employee names , Department and salary only.
		Query query3 = session.createQuery("select ename , esalary , edepartment from Employee ");
		List<Object[]> nameAndSalaryAndDept = query3.getResultList();
		
		for (Object[] objects : nameAndSalaryAndDept) {
			System.out.println(Arrays.toString(objects));
		}
		
		// Query 4 :Display highest paid Salary
		Query query4 = session.createQuery("from Employee where esalary = (select max(esalary) from Employee)");
		List<Employee> maxSalary = query4.getResultList();
		
		for (Employee object : maxSalary) {
			System.out.println(object);
		}
		
		// Query 5 : find bottom five with salary
		Query query5 = session.createQuery("from Employee order by esalary asc"); // asc for ascending order
		query5.setMaxResults(5);
		List<Employee> bottom5 = query5.getResultList();
		
		for (Employee object : bottom5) {
			System.out.println(object);
		}
		
		// Query 6 : find Top five with salary
		Query query6 = session.createQuery("from Employee order by esalary desc"); // desc for ascending order
		query6.setMaxResults(5);
		List<Employee> top5 = query6.getResultList();
		
		for (Employee object : top5) {
			System.out.println(object);
		}
		
		// Query 7 : display employee where salary greater then host salary.
		Query query7 = session.createQuery("from Employee where esalary = (select max(esalary) from Employee where ename = :ename)");
		query7.setParameter("ename", "Yogesh");
		List<Employee> salary = query7.getResultList();
		
		for (Employee object : salary) {
			System.out.println(object);
		}
		
		System.out.println();

		// Query 8 : Display employee belongs to It and HR department.
		Query query8 = session.createQuery("from Employee where edepartment in ('IT','HR')");
		List<Employee> itAndHr = query8.getResultList();

		for (Employee dept : itAndHr) {
			System.out.println(dept);
		}
		
		System.out.println();
		
		// Query 9 : Display employee belongs to Pune and Mumbai.
		Query query9 = session.createQuery("from Employee where ecity in ('Pune','Mumbai')");
		List<Employee> city = query9.getResultList();

		for (Employee puneAndMumbai : city) {
			System.out.println(puneAndMumbai);
		}
		
		System.out.println();
		
		// Query 10 : Display employee where name contain specific name.
		Query query10 = session.createQuery("from Employee where ename like :ename");
		query10.setParameter("ename", "%Yogesh%");
		List<Employee> sameName = query10.getResultList();

		for (Employee names : sameName) {
			System.out.println(names);
		}

		tx.commit();

	}

	private static void addEmployeeDetails(SessionFactory sf) {
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Employee emp = new Employee();
		emp.setEname("Yogesh");
		emp.setEdepartment("HR");
		emp.setEsalary(1200000);
		emp.setEcity("Mumbai");

		session.save(emp);

		tx.commit();
	}

}
