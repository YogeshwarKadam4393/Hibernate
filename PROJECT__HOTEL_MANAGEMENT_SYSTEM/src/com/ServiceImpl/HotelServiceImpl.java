package com.ServiceImpl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Hotel;
import com.service.HotelService;
import com.util.HibernateUtil;

public class HotelServiceImpl implements HotelService{

	 SessionFactory sf= HibernateUtil.getSesstionFactory();
	 Scanner sc = new Scanner(System.in);
	 @Override
	 public void addHotel() {

	     Session session = sf.openSession();
	     Transaction tx = session.beginTransaction();

	     Hotel hotel = new Hotel();

	     System.out.println("Enter hotel name : ");
	     String name = sc.nextLine();
	     hotel.setHotelName(name);

	     System.out.println("Enter description : ");
	     String description = sc.nextLine();
	     hotel.setDescription(description);

	     System.out.println("Enter City : ");
	     String city = sc.nextLine();
	     hotel.setCity(city);

	     System.out.println("Enter rating : ");
	     String rating = sc.nextLine();
	     hotel.setRating(rating);

	     System.out.println("Enter contact number : ");
	     long contactNumber = sc.nextLong();
	     hotel.setContactNumber(contactNumber);

	     session.save(hotel);

	     tx.commit();
	     System.out.println("Hotel added successfully!");
	 }

	 @Override
	 public void updateHotel(int id) {

	     Session session = sf.openSession();
	     Transaction tx = session.beginTransaction();

	     Hotel hotel = session.get(Hotel.class, id);

	     if (hotel == null) {
	         System.out.println("Hotel not found with ID : " + id);
	         
	     }

	     System.out.println("\nSelect field to update:");
	     System.out.println("1. Hotel Name");
	     System.out.println("2. Description");
	     System.out.println("3. City");
	     System.out.println("4. Rating");
	     System.out.println("5. Contact Number");
	     System.out.println("6. Update All Fields");

	     System.out.println("Enter your choice : ");
	     int ch = sc.nextInt();
	     sc.nextLine();

	     switch (ch) {

	     case 1:
	         System.out.println("Enter new hotel name : ");
	         String name = sc.nextLine();
	         hotel.setHotelName(name);
	         break;

	     case 2:
	         System.out.println("Enter new description : ");
	         String description = sc.nextLine();
	         hotel.setDescription(description);
	         break;

	     case 3:
	         System.out.println("Enter new city : ");
	         String city = sc.nextLine();
	         hotel.setCity(city);
	         break;

	     case 4:
	         System.out.println("Enter new rating : ");
	         String rating = sc.nextLine();
	         hotel.setRating(rating);
	         break;

	     case 5:
	         System.out.println("Enter new contact number : ");
	         long contactNumber = sc.nextLong();
	         hotel.setContactNumber(contactNumber);
	         break;
	     default:
	         System.out.println("Invalid choice!");
	        
	     }

	     session.update(hotel);

	     tx.commit();


	     System.out.println("Hotel updated successfully!");

	    
	 }

	@Override
	public void deleteHotel(int id) {
		Session session = sf.openSession();
		Transaction tx= session.beginTransaction();
		Hotel hotel= session.get(Hotel.class, id);
		session.delete(hotel);
		tx.commit();
		
		
	}

	@Override
	public Hotel findHotelById(int id) {
		 Session session = sf.openSession();
		 Hotel hotel = session.get(Hotel.class, id);

	     if (hotel == null) {
	         System.out.println("Hotel not found with ID : " + id);
	         
	     }
	     
		return hotel;
	}

	@Override
	public List<Hotel> getAllHotels() {

	    Session session = sf.openSession();
       Query query  = session.createQuery("from Hotel");
       List<Hotel> hotels =  query.getResultList();

	    return hotels;
	}
	@Override
	public List<Hotel> searchHotelsByCity(String city) {

	    Session session = sf.openSession();

	    Query query = session.createQuery("from Hotel where city = :city");
	    query.setParameter("city", city);
	    List<Hotel> hotels = query.getResultList();

	    return hotels;
	}

	@Override
	public List<Hotel> findHotelsByRating(String rating) {
		  Session session = sf.openSession();

		    Query query = session.createQuery("from Hotel where rating = :rating");
		    query.setParameter("city", rating);
		    List<Hotel> hotels = query.getResultList();

		    return hotels;
	}

}
