package com.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.FoodItem;
import com.util.HibernateUtil;

public class FoodService {

	public static SessionFactory sf = HibernateUtil.getSessionFactory();

	public void addFood(FoodItem foodItem) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

//		FoodItem foodItem = new FoodItem();
//		foodItem.setName("Samosa");
//		foodItem.setPrice(20);
//		foodItem.setCategory("Breakfast");
//		foodItem.setQuantity(2);

		session.save(foodItem);
		tx.commit();
		System.out.println("Record Inserted...");

		// System.out.println(foodItem);

	}

	public void deleteItemById(int id) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		FoodItem foodItem = session.get(FoodItem.class, id);

		if (foodItem == null) {

			throw new RuntimeException("Given id is Not Available");

		}

		session.delete(foodItem);

		tx.commit();

	}

//	public void deleteItemById(int id) {
//
//	    Session session = sf.openSession();
//
//	    Transaction tx = session.beginTransaction();
//
//	    Query query = session.createQuery(
//	            "DELETE FROM FoodItem WHERE id = :inputId");
//	    
//	    //"Delete FoodItem where category = 'Lunch'"
//
//	    query.setParameter("inputId", id);
//
//	    int result = query.executeUpdate();
//	    System.out.println(result);   // This will Give how Rows are Affected By query.executeUpdate 

//	    if (result > 0) {
//	        tx.commit();
//	        System.out.println("Food Item Deleted...");
//	    } else {
//	        tx.rollback();
//	        throw new RuntimeException("Given id is Not Available");
//	    }
//
//	    session.close();
//	}

	public void deleteItemByName(String name) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("Delete FoodItem where category = 'Breakfast'");

		tx.commit();

	}

	public FoodItem getItemById(int id) {

		Session session = sf.openSession();
		FoodItem foodItem = session.get(FoodItem.class, id);

		return foodItem;
	}

	public List<FoodItem> getAllDetails() {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("from FoodItem");
		List<FoodItem> allFoodDetails = query.getResultList();

		return allFoodDetails;
	}

	public void updateFoodDetails(int id, double price) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("UPDATE FoodItem SET Price = :updatedPrice where id = :inputId");
		query.setParameter("updatedPrice", price);
		query.setParameter("inputId", id);
		query.executeUpdate(); // This is used when Doing Update & Delete

		tx.commit();

	}
}
