package com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Passport;
import com.entity.Person;
import com.util.HibernateUtil;

public class PassportService {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	public String addPerson(Person person) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(person);
		tx.commit();
		System.out.println("Added Person");
		return "Saved Person";

	}

	public Person getPerson(int id) {

		Session session = sf.openSession();

		Person person = session.get(Person.class, id);

		return person;

	}

	public Passport getPassport(int id) {

		Session session = sf.openSession();

		Passport passport = session.get(Passport.class, id);

		return passport;

	}

	public String updatePassport(int id, String updatecountry) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Person person = session.get(Person.class, id);

		Passport passport = person.getPassport();
		passport.setPassportcountry(updatecountry);

		session.save(passport);
		System.out.println(person);
		tx.commit();

		return updatecountry;

	}

	public void deletePerson() {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		// Person person = session.get(Person.class, 1);
		Passport passport = session.get(Passport.class, 1);

		session.delete(passport);
//                person.setPassport(null);
//                 session.delete(person);
		tx.commit();
		System.out.println("Delete Person");
	}
}
