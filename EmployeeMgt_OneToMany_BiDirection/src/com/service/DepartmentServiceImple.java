package com.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Department;
import com.entity.Employee;
import com.util.HibernateUtil;

public class DepartmentServiceImple implements DepartmentService {

	SessionFactory sf = HibernateUtil.getSesstionFactory();

	
	
	@Override
	public void addEmployeeAndDepartment(Department department) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(department);

		tx.commit();

		System.out.println("Employees Added in Department Successfully");
	}

	@Override
	public Employee updateDepartmentNameByEmployeeId() {

	    Session session = sf.openSession();

	    Transaction tx = session.beginTransaction();

//	    Department department1 = session.get(Department.class, departmentId);
	    
	    Employee employee = session.get(Employee.class, 1);
	    
	    Department department = employee.getDepartment();
	    
	    department.setDepartmentName("UI/UX");
	    
	    session.update(employee);

	    tx.commit();

	    System.out.println("Update Department Name Using Employee Id Completed...!!");
	    
	    return employee;
	}

	@Override
	public Department updateEmployeeUsingDepartmentId(int departmentId) {

	    Session session = sf.openSession();

	    Transaction tx = session.beginTransaction();

	    Department department1 = session.get(Department.class, departmentId);

	    List<Employee> updateEmployeeUsingDepartmentId = department1.getEmployees();

	    Employee employee = null;
	    
	    for (Employee employees : updateEmployeeUsingDepartmentId) {
	        
	        if(employees.getEmployeeId() == 1) {
	            employee = employees;
	        }else {
	            System.out.println("Enter Valid Id...!!");
	        }
	    }
	    
	    employee.setEmployeeName("Yogesh");
	    employee.setEmployeeCity("Dubai");
	//  employee.setDepartment(department);

	    session.update(department1);

	    tx.commit();

	    System.out.println("Update Employee Using Department Id Completed...!!");
	    
	    return department1;
	}
	
	@Override
	public Department deleteDepartmentById(int departmentId) {
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Department department = session.get(Department.class, departmentId);
		
		session.delete(department);
		
		tx.commit();
		
		System.out.println("Department Deleted SuccessFully...!!");
		
		return department;
	}
	
	@Override
	public Department deleteEmployeeById(int departmentId,int employeeId) {
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Department department = session.get(Department.class, departmentId);
		
		Employee employee = null;
		
		List<Employee> employees= department.getEmployees();
		
		for (Employee employees1 : employees) {
			
			if(employees1 != null && employees1.getEmployeeId()  == employeeId) {
				employee = employees1;
			}
		}

		employees.remove(employee);
		
		session.delete(employee);
		
		tx.commit();
		
		System.out.println("Employee Deleted SuccessFully...!!");
		
		return department;
	}

	@Override
	public void addEmployeeInExistingDepartment(int departmentId) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Department department = session.get(Department.class, departmentId);

		List<Employee> addEmployeesInExistingDepartment = department.getEmployees();

		Employee emp = new Employee();
		emp.setEmployeeName("Yusuf");
		emp.setEmployeeCity("Pune");
		emp.setDepartment(department);

		addEmployeesInExistingDepartment.add(emp);

		session.save(department);

		tx.commit();

		System.out.println("Employees Added in Existing Department Successfully");
	}

	@Override
	public void addDepartmentOnly(Department department) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(department);

		tx.commit();

		System.out.println("Department Added Successfully");
	}

	@Override
	public List<Department> getAllDepartmentsOnly() {

		Session session = sf.openSession();

		Query query = session.createQuery("from Department");

		List<Department> listOfDepartments = query.getResultList();

		for (Department department : listOfDepartments) {
			System.out.println(department);
//	        System.out.println(department.getEmployees());
		}

		session.close();

		System.out.println("Departments Displayed...!!");

		return listOfDepartments;
	}

	@Override
	public List<Employee> getAllEmployeesOnly() {

		Session session = sf.openSession();

		Query query = session.createQuery("from Employee");

		List<Employee> listOfEmployees = query.getResultList();

		for (Employee employees : listOfEmployees) {
			System.out.println(employees);
		}

		session.close();

		System.out.println("Employees Displayed...!!");

		return listOfEmployees;
	}

}