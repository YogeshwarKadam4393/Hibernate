package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Details")   // This is used to give the table Name 
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // This is used For Auto Increment
	private int eid;
	
	@Column(name = "Employee_name", nullable = false , length = 10) // This is used if you want to change your Column Name
	private String ename;
	
	@Column(name = "Employee_address", nullable = false , length = 10)
	private String eaddress;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + "]";
	}
	
	

}
