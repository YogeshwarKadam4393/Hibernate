package com.controller;

import com.entity.Passport;
import com.entity.Person;
import com.service.PassportService;

public class Application {

	public static void main(String[] args) {

		Person person = new Person();
		person.setPersonName("Ajay");
		person.setPesronAddress("Mumbai");
		person.setPesronAge(21);
		person.setPesronEmail("ajayjadhav0157@gmail.com");
		person.setPesronGender("Male");

		Passport passport = new Passport();
		passport.setPassportnumber("IN654321");
		passport.setPassportcountry("China");

		person.setPassport(passport);

		PassportService ps = new PassportService();
		String msg = ps.addPerson(person);
		System.out.println("Printintg Person :" + msg);

		// Get Person

//	     	int id = 3;
//		  Person person = ps.getPerson(id);
//		  System.out.println("Printing Person :"+person);

		// Get Passport

//	      int id = 2;
//	      Passport passport = ps.getPassport(id);   
//	      System.out.println("Printing Passport :"+passport);

		// Update Passport
//		int id = 1;
//		String updatecountry = "PUNE";
//		   String country =  ps.updatePassport(id , updatecountry);
//             System.out.println("Update Country Success :"+country);

		// ps.deletePerson();

	}

}
