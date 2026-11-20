package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int personId;
	
	private String personName;
	
	private String pesronAddress;
	
	private int pesronAge;
	
	private String pesronGender;
	
	private String pesronEmail;
	
	@JoinColumn(name = "Passport_Id")
	@OneToOne (cascade = CascadeType.ALL)
    private Passport passport;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPesronAddress() {
		return pesronAddress;
	}

	public void setPesronAddress(String pesronAddress) {
		this.pesronAddress = pesronAddress;
	}

	public int getPesronAge() {
		return pesronAge;
	}

	public void setPesronAge(int pesronAge) {
		this.pesronAge = pesronAge;
	}

	public String getPesronGender() {
		return pesronGender;
	}

	public void setPesronGender(String pesronGender) {
		this.pesronGender = pesronGender;
	}

	public String getPesronEmail() {
		return pesronEmail;
	}

	public void setPesronEmail(String pesronEmail) {
		this.pesronEmail = pesronEmail;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", pesronAddress=" + pesronAddress
				+ ", pesronAge=" + pesronAge + ", pesronGender=" + pesronGender + ", pesronEmail=" + pesronEmail
				+ ", passport=" + passport + "]";
	}
}

