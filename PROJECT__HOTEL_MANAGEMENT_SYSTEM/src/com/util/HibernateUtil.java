package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Hotel;
import com.entity.Room;

public class HibernateUtil {

	public static SessionFactory sf;

	public static SessionFactory getSesstionFactory() {

		Configuration cfg = new Configuration();

		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/PROJECT_HOTEL_MANAGEMENT_SYSTEM");
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password", "root");

		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
		cfg.setProperty("hibernate.show_sql", "true");

		cfg.addAnnotatedClass(Hotel.class).addAnnotatedClass(Room.class);
		sf = cfg.buildSessionFactory();

		return sf;

	}
}
