package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Department;
import com.entity.Employee;

public class HibernateUtil {
	
	public static SessionFactory sf = null;
	
	public static Configuration cfg = new Configuration();
	
	public static SessionFactory getSessionFactory() {
		
		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/yogesh");
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password", "root");

		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
		cfg.setProperty("hibernate.show_sql", "true");
		
		cfg.addAnnotatedClass(Department.class).addAnnotatedClass(Employee.class);
		
		sf = cfg.buildSessionFactory();
		
		return sf;
	}

}
