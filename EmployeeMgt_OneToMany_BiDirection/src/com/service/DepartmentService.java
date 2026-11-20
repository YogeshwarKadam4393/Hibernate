package com.service;

import java.util.List;

import com.entity.Department;
import com.entity.Employee;

public interface DepartmentService {
	
	public void addEmployeeAndDepartment(Department department);
	
	public void addDepartmentOnly(Department department);
	
	public void addEmployeeInExistingDepartment(int departmentId);
	
	public List<Department> getAllDepartmentsOnly();
	
	public List<Employee> getAllEmployeesOnly() ;
	
	public Department updateEmployeeUsingDepartmentId(int departmentId);
	
	public Department deleteEmployeeById(int departmentId,int employeeId);
	
	public Department deleteDepartmentById(int departmentId);
	
	public Employee updateDepartmentNameByEmployeeId();
}
