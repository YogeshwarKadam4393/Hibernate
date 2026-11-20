package com.hotelController;

import java.util.List;
import java.util.Scanner;

import com.ServiceImpl.HotelServiceImpl;
import com.ServiceImpl.RoomServicesImpl;
import com.entity.Hotel;
import com.entity.Room;

public class HotelController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		HotelServiceImpl hotel = new HotelServiceImpl();
		RoomServicesImpl room = new RoomServicesImpl();

		boolean flag = true;
		
		while(flag) {
		System.out.println("1. Add hotel Details");
		System.out.println("2. Update hotel Details");
		System.out.println("3. Find hotel by using id");
		System.out.println("4. Get all Hotels details");
		System.out.println("5. Search hotel by city");
		System.out.println("6. Add room in hotel");
		System.out.println("7. Update room");
		System.out.println("8. Delete room");
		System.out.println("9. Get room by id");
		System.out.println("10. Get all rooms");
		System.out.println("11. Get rooms by hotel");
		System.out.println("12. Find rooms by room type");
		System.out.println("13. Find rooms by price range");
		System.out.println("14. Find available rooms");

		System.out.println("Enter your choice : ");

		int ch = sc.nextInt();

		switch (ch) {

		case 1:
			hotel.addHotel();
			break;

		case 2:
			System.out.println("Enter hotel id to update : ");
			int id = sc.nextInt();

			hotel.updateHotel(id);
			break;

		case 3:
			System.out.println("Enter hotel id : ");
			int Id = sc.nextInt();

			hotel.findHotelById(Id);
			break;

		case 4:
			List<Hotel> hotels = hotel.getAllHotels();

			for (Hotel ht : hotels) {
				System.out.println(ht);
			}
			break;

		case 5:
			System.out.println("Enter city : ");
			String city = sc.next();

			hotel.searchHotelsByCity(city);
			break;

		case 6:
			System.out.println("Enter hotel id : ");
			int hotelId = sc.nextInt();

			room.addRoomToHotel(hotelId);
			break;

		case 7:
			System.out.println("Enter hotel id : ");
			int hId = sc.nextInt();

			room.updateRoom(hId);
			break;

		case 8:
			System.out.println("Enter hotel id : ");
			int hid = sc.nextInt();

			room.deleteRoom(hid);
			break;

		case 9:
			System.out.println("Enter hotel id : ");
			int hotelID = sc.nextInt();

			Room rm = room.getRoomById(hotelID);

			System.out.println(rm);
			break;

		case 10:
			List<Room> rooms = room.getAllRooms();

			for (Room r : rooms) {
				System.out.println(r);
			}
			break;

		case 11:
			System.out.println("Enter hotel id : ");
			int hotel_Id = sc.nextInt();

			List<Room> hotelRooms = room.getRoomsByHotel(hotel_Id);

			for (Room r : hotelRooms) {
				System.out.println(r);
			}
			break;

		case 12:
			System.out.println("Enter hotel id : ");
			int hotel_id = sc.nextInt();

			List<Room> roomsByType = room.findRoomsByRoomType(hotel_id);

			for (Room r : roomsByType) {
				System.out.println(r);
			}
			break;

		case 13:

			break;

		case 14:
			System.out.println("Enter hotel id : ");
			int availableHotelId = sc.nextInt();

			List<Room> availableRooms = room.findAvailableRooms(availableHotelId);

			for (Room r : availableRooms) {
				System.out.println(r);
			}
			break;
		case 15:
			System.out.println("Exit");
			flag = false;
			break;

		default:
			System.out.println("Invalid choice!");
			break;
		}
		}

		sc.close();
	}
}