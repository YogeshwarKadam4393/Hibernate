package com.service;

import java.util.List;

import com.entity.Student;

public interface StudentService {
	
	public void registerStudent(Student registerStudent);
	
	public List<Student> displayAllStudent();
	
	public Student getStudentById(int id);
	
	public void updateStudentById(int id);
	
	public void deleteStudentById(int id);
		
	public List<Student> searchStudentByCity(String city);

	public List<Student> searchStudentByCourse(String course);
	
	public List<Student> studentWithFeesGreaterThan(double fees);
	
	public List<Student> Top5HighestFeesStudent();


}
