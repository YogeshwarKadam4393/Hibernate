package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Book;
import com.entity.Library;

public class HibernateUtil {

	public static SessionFactory sf;

	public static SessionFactory getSesstionFactory() {

		Configuration cfg = new Configuration();

		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/LibraryMgt_OneToMany_Uni");
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password", "root");

		cfg.setProperty("hibernate.dailect", "org.hibernate.dailect.MySQL8Dailect");
		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
		cfg.setProperty("hibernate.show_sql", "true");

		cfg.addAnnotatedClass(Library.class).addAnnotatedClass(Book.class);
		sf = cfg.buildSessionFactory();

		return sf;

	}
}
