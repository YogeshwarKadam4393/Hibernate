package com.ServiceImpl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Hotel;
import com.entity.Room;
import com.service.RoomService;
import com.util.HibernateUtil;

public class RoomServicesImpl implements RoomService {
	Scanner sc = new Scanner(System.in);
	SessionFactory sf = HibernateUtil.getSesstionFactory();

	@Override
	public Room addRoomToHotel(int hotelId) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Hotel hotel = session.get(Hotel.class, hotelId);

		if (hotel == null) {
			System.out.println("Hotel not found with ID : " + hotelId);
		}

		Room room = new Room();

		System.out.println("Enter room number : ");
		int roomNumber = sc.nextInt();
		room.setRoomNumber(roomNumber);
		sc.nextLine();

		System.out.println("Enter room type : ");
		String roomType = sc.nextLine();
		room.setRoomType(roomType);

		System.out.println("Enter room price : ");
		double price = sc.nextDouble();
		room.setPrices(price);

		System.out.println("Enter availability : ");
		String available = sc.nextLine();
		room.setAvailable(available);

		room.setHotel(hotel);

		session.save(room);

		tx.commit();

		System.out.println("Room added successfully ");

		return room;
	}

	@Override
	public void updateRoom(int hotelId) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Hotel hotel = session.get(Hotel.class, hotelId);

		if (hotel == null) {
			System.out.println("Hotel not found with ID : " + hotelId);

		}

		System.out.println("Enter room id");
		int roomId = sc.nextInt();
		sc.nextLine();

		Room room = session.get(Room.class, roomId);

		if (room == null) {
			System.out.println("Room not found with ID : " + roomId);

		}

		System.out.println("\nSelect field to update:");
		System.out.println("1. Room Number");
		System.out.println("2. Room Type");
		System.out.println("3. Price");
		System.out.println("4. Availability");
		System.out.println("5. Update All Fields");

		System.out.println("Enter your choice : ");
		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {

		case 1:
			System.out.println("Enter new room number : ");
			int roomNumber = sc.nextInt();
			room.setRoomNumber(roomNumber);
			break;

		case 2:
			System.out.println("Enter new room type : ");
			String roomType = sc.nextLine();
			room.setRoomType(roomType);
			break;

		case 3:
			System.out.println("Enter new room price : ");
			double price = sc.nextDouble();
			room.setPrices(price);
			break;

		case 4:
			System.out.println("Enter availability : ");
			String available = sc.nextLine();
			room.setAvailable(available);
			break;

		default:
			System.out.println("Invalid choice!");

		}

		session.update(room);

		tx.commit();

		session.close();

		System.out.println("Room updated successfully!");
	}

	@Override
	public void deleteRoom(int Id) {

		Scanner sc = new Scanner(System.in);

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Hotel hotel = session.get(Hotel.class, Id);

		if (hotel == null) {
			throw new RuntimeException("Hotel not found");
		}

		System.out.println("Enter room id to delete:");
		int roomId = sc.nextInt();

		List<Room> room = hotel.getRoom();

		// value assign keli list iteration mdhun aaleli
		Room rooms = null;

		for (Room rm : room) {

			System.out.println(rm);

			if (rm.getId() == roomId) {
				rooms = rm;

				// session.delete(rooms);
				// room.remove(rooms);
			}
		}

		if (rooms != null) {

			session.delete(rooms);

			System.out.println("Room deleted successfully.");

		} else {

			System.out.println("Room not found.");

		}

		session.update(hotel);
		tx.commit();
		session.close();
	}

	@Override
	public Room getRoomById(int hotelId) {

		Scanner sc = new Scanner(System.in);

		Session session = sf.openSession();

		Hotel hotel = session.get(Hotel.class, hotelId);

		if (hotel == null) {
			throw new RuntimeException("Hotel not found");
		}

		System.out.println("Enter room id to search:");
		int roomId = sc.nextInt();

		List<Room> room = hotel.getRoom();

		Room rooms = null;

		for (Room rm : room) {

			System.out.println(rm);

			if (rm.getId() == roomId) {
				rooms = rm;
			}
		}

		if (rooms != null) {

			System.out.println("Room found successfully.");
			System.out.println(rooms);

		} else {

			System.out.println("Room not found.");

		}

		session.close();

		return rooms;
	}

	@Override
	public List<Room> getAllRooms() {

		Session session = sf.openSession();

		Query query = session.createQuery("from Room");

		List<Room> rooms = query.getResultList();

		return rooms;
	}

	@Override
	public List<Room> getRoomsByHotel(int hotelId) {
		Session session = sf.openSession();

		Hotel hotel = session.get(Hotel.class, hotelId);

		if (hotel == null) {
			throw new RuntimeException("Hotel not found");
		}

		Query query = session.createQuery("from Room  where id = :hotelId");

		query.setParameter("hotelId", hotelId);

		List<Room> rooms = query.getResultList();

		return rooms;
	}

	@Override
	public List<Room> findRoomsByRoomType(int HotelId) {

		Session session = sf.openSession();

		Hotel hotel = session.get(Hotel.class, HotelId);

		if (hotel == null) {
			throw new RuntimeException("Hotel not found");
		}

		Query query = session.createQuery("from Room  where id = :hotelId");

		query.setParameter("hotelId", HotelId);

		List<Room> rooms = query.getResultList();

		return rooms;
	}


	@Override
	public List<Room> findAvailableRooms(int id) {

		Session session = sf.openSession();

		Hotel hotel = session.get(Hotel.class, id);

		if (hotel == null) {
			throw new RuntimeException("Hotel not found");
		}

		Query query = session.createQuery("from Room where hotel.hotelId = :hotelId " + "and available = :available");

		query.setParameter("hotelId", id);
		query.setParameter("available", "available");

		List<Room> rooms = query.getResultList();

		for (Room room : rooms) {
			System.out.println(room);
		}

		session.close();

		return rooms;
	}

	@Override
	public List<Room> findRoomsByPriceRange(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}


}
