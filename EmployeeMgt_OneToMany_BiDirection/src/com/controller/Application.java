package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.entity.Department;
import com.entity.Employee;
import com.service.DepartmentService;
import com.service.DepartmentServiceImple;

// Question  : 1 + N queries = N+1 problem
// Answer ---> Interview Definition : "N+1 problem is a Hibernate performance issue where 1 query is used to fetch 
//             parent entities and N additional queries are executed to fetch their child entities individually."
//			   One Query For Department And Other Queries For List Of Department

// Question  : Why is it a problem?
// Answer ---> Because it generates too many database queries, which can make the application slow, especially 
//             when we have a large number of records.

// Question  : How can we solve it?
// Answer ---> Common solutions are: 1.JOIN FETCH  2.Entity Graph  3.Batch fetching  4.Properly choosing EAGER/Lazy 
//			   fetching based on requirement.

// Question  : What is Fetch Type?
// Answer ---> Fetch type decides when Hibernate will load related data from the database.
//             Types 1.Eager Loading  2.Lazy Loading

// Question  : EAGER Fetching ---> EAGER means: Load the related data immediately along with the Child data.
// Question  : LAZY Fetching --->  Don't load related data immediately.Load Child data only when we access it.
// Interview Answer ---> FetchType defines when Hibernate loads associated entities. EAGER loads the associated 
//                       data immediately, while LAZY loads it only when we access it.In Hibernate/JPA, OneToOne 
//                       and ManyToOne are EAGER by default, whereas OneToMany and ManyToMany are LAZY by default.

public class Application {

	public static void main(String[] args) {

		boolean flag = true;

		while (flag) {
			
			DepartmentService depService = new DepartmentServiceImple();

			Scanner sc = new Scanner(System.in);

			System.out.println("==============================================");
			System.out.println("       DEPARTMENT - EMPLOYEE MANAGEMENT");
			System.out.println("==============================================");

			System.out.println("1. Add Employee And Department");
			System.out.println("2. Display All Departments");
			System.out.println("3. Display All Employees");
			System.out.println("4. Add Department Only");
			System.out.println("5. Add Employee In Existing Department");
			System.out.println("6. Update Employee Using Department ID");
			System.out.println("7. Delete Employee By ID");
			System.out.println("8. Delete Department By ID");
			System.out.println("9. Update Department Name By Employee ID");
			System.out.println("10 . Exit");

			System.out.println("==============================================");
			System.out.print("Enter Your Choice : ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				AddEmployeeAndDepartment();
				break;
			case 2:
				List<Department> listOfDepartments = depService.getAllDepartmentsOnly();
				break;
			case 3:
				List<Employee> listOfEmployees = depService.getAllEmployeesOnly();
				break;
			case 4:
				AddDepartmentOnly();
				break;
			case 5:
				depService.addEmployeeInExistingDepartment(1);
				break;
			case 6:
				depService.updateEmployeeUsingDepartmentId(1);
				break;
			case 7:
				depService.deleteEmployeeById(4, 8);
				break;
			case 8:
				depService.deleteDepartmentById(5);
				break;
			case 9:
				depService.updateDepartmentNameByEmployeeId();
				break;
			case 10:
				System.out.println("Application Closed...!!");
				flag = false;
				break;
			default:
				System.out.println("Enter Valid Choice...!!");
			}
		}
	}
	

	private static void AddDepartmentOnly() {

		DepartmentService depService = new DepartmentServiceImple();

		Department department = new Department();
		department.setDepartmentName("NDA");
		department.setPhoneNo(9898933389l);
		department.setLocation("Pune");
		department.setEmail("NDA@gmail.com");

		depService.addDepartmentOnly(department);

	}

	private static void AddEmployeeAndDepartment() {

		DepartmentService depService = new DepartmentServiceImple();

		Department department = new Department();
		department.setDepartmentName("Cyber Security");
		department.setPhoneNo(989898989l);
		department.setLocation("Pune");
		department.setEmail("hr@gmail.com");

		List<Employee> listOfEmployees = new ArrayList<Employee>();

		Employee employee1 = new Employee();
		employee1.setEmployeeName("Yogesh");
		employee1.setEmployeeCity("Pune");
		employee1.setDepartment(department);

		Employee employee2 = new Employee();
		employee2.setEmployeeName("Lalit");
		employee2.setEmployeeCity("Pune");
		employee2.setDepartment(department);

		listOfEmployees.add(employee1); // Add employee in list
		listOfEmployees.add(employee2);

		department.setEmployees(listOfEmployees);

		depService.addEmployeeAndDepartment(department);

	}

}
