package com.controller;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Product;
import com.util.HibernateUtil;

public class Application {
	
	public static void main(String[] args) {
		
		System.out.println("Application Started");
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder(); // Criteria Builder : Provides Multiple Functions
		
		CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class); // Create Query : It helps to create query using Table Name
		
		Root<Product> root = query.from(Product.class); // Root : Holds the information of Table/Entity
		
		query.select(root);
		
		// Select * from Product where pname = Iphone;
		
		query.where(criteriaBuilder.equal(root.get("pname"),"Iphone"));
		
		Query query1 = session.createQuery(query);
		
		List<Product> products = query1.getResultList();
		
		for (Product product : products) {
			System.out.println(product);
		}
		
		tx.commit();
		
	}

}
