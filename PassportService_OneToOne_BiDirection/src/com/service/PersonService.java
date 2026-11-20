package com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Person;
import com.util.HibernateUtil;

public class PersonService {

	SessionFactory sf = HibernateUtil.getSesstionFactory();

	public Person addPerson(Person person) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(person);

		tx.commit();
		System.out.println("Added Person");
		return person;
	}

	public void getPerson() {

		Session session = sf.openSession();

		// Passport passport = session.get(Passport.class,2);
		Person person = session.get(Person.class, 1);
		// System.out.println(passport);
		// System.out.println(passport.getPerson());
		System.out.println(person);
		System.out.println(person.getPassport());
		// return passport;

	}

	public String updatePerson(int id, String updateaddress) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Person person = session.get(Person.class, id);

		person.setPersonAddress(updateaddress);
		session.save(person);
		tx.commit();
		return updateaddress;
	}

	public void deletePerson() {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Person person = session.get(Person.class, 2);

		session.delete(person);
		tx.commit();
		System.out.println("Delete Person");
	}
}
