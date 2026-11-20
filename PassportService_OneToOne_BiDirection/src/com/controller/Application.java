package com.controller;

import com.entity.Passport;
import com.entity.Person;
import com.service.PersonService;

public class Application {

	public static void main(String[] args) {

		Person person = new Person();

		person.setPersonName("Vijay");
		person.setPersonAddress("Pune");
		person.setPersonGender("Male");
		person.setPersonAge(20);
		person.setPersonEmail("vijayjadhav0157@gmail.com");

		Passport passport = new Passport();

		passport.setPassportNumber("IND1234");
		passport.setPassportCountry("INDIA");

		passport.setPerson(person);
		person.setPassport(passport);

		PersonService ps = new PersonService();

		Person msg = ps.addPerson(person);
		System.out.println("Printing Person :" + msg);

		// getpassport

		// int id =1;
		// ps.getPerson();
		// System.out.println("Printing Passport :"+msg);

		// Update
//		
//	     int id = 2;
//	     String updateaddress = "SATARA";
//	    String msg = ps.updatePerson(id , updateaddress);
//	          System.out.println("Update Address:"+msg);

		// Delete
		// ps.deletePerson();
	}
}
