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
		
		addEmployeeDetails(sf);

		// Query 1 :Display all employee names.
		Query query1 = session.createQuery("from Employee");
		List<Employee> listOfEmployees = query1.getResultList();

		for (Employee employee : listOfEmployees) {
			System.out.println(employee);
		}

		System.out.println();

		// Query 2 :Display employee names and salary only.
		Query query2 = session.createQuery("select ename,esalary from Employee");
		List<Object[]> nameAndSalary = query2.getResultList();

		for (Object[] object1 : nameAndSalary) {
			System.out.println(Arrays.toString(object1));
		}

		System.out.println();

		// Query 3 :Display employee names , Department and salary only.
		Query query3 = session.createQuery("select ename,edepartment,esalary from Employee");
		List<Object[]> nameAndSalaryAndDepartment = query3.getResultList();

		for (Object[] object2 : nameAndSalaryAndDepartment) {
			System.out.println(Arrays.toString(object2));
		}

		System.out.println();

		// Query 4 : Find the highest Salary from Employee
		Query query4 = session.createQuery("from Employee where esalary = (select max(esalary) from Employee)");
		List<Employee> highestPaidSalary = query4.getResultList();

		for (Employee employee : highestPaidSalary) {
			System.out.println(employee);
		}

		System.out.println();

		// Query 5 : Find the bottom 5 from Employee with salary
		Query query5 = session.createQuery("from Employee order by esalary asc");
		query5.setMaxResults(5);
		List<Employee> bottom5Employees = query5.getResultList();

		for (Employee bottom5Employee : bottom5Employees) {
			System.out.println(bottom5Employee);
		}

		System.out.println();


		// Query 6 : Display employee where salary is greater than Tejas's salary
		Query query6 = session.createQuery("from Employee where esalary > (select esalary from Employee where ename = :ename)");
		query6.setParameter("ename", "Tejas");
		List<Employee> host = query6.getResultList();

		for (Employee hostSalary : host) {
			System.out.println(hostSalary);
		}
		
		System.out.println();
		
		// Query 7 : Display employees working in particular department.
		Query query7 = session.createQuery("from Employee where edepartment = :edepartment");
		query7.setParameter("edepartment", "Java Developer");
		List<Employee> employeesFromSameDepart = query7.getResultList();

		for (Employee empDept : employeesFromSameDepart) {
			System.out.println(empDept);
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
