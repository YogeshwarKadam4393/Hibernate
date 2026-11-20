package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;

	private String middleName;

	private String lastName;

	private String city;

	private String email;

	private String phnNo;

	private String course;

	private String batch;

	private double fees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhnNo() {
		return phnNo;
	}

	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Student Details\n"
				+ "------------------------------\n"
				+ "ID          : " + id + "\n"
				+ "First Name  : " + firstName + "\n"
				+ "Middle Name : " + middleName + "\n"
				+ "Last Name   : " + lastName + "\n"
				+ "City        : " + city + "\n"
				+ "Email       : " + email + "\n"
				+ "Phone No    : " + phnNo + "\n"
				+ "Course      : " + course + "\n"
				+ "Batch       : " + batch + "\n"
				+ "Fees        : " + fees + "\n"
				+ "------------------------------";
	}

}
