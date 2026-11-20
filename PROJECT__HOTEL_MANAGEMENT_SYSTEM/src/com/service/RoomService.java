package com.service;

import java.util.List;

import com.entity.Room;

public interface RoomService {
	
	public Room addRoomToHotel(int hotelId);

	public void updateRoom(int roomId);

	public void deleteRoom(int roomId);

	public Room getRoomById(int roomId);

	public List<Room> getAllRooms();

	public List<Room> getRoomsByHotel(int hotelId);

	public List<Room> findRoomsByRoomType(int HotelId);

	public List<Room> findRoomsByPriceRange(double minPrice, double maxPrice);

	public List<Room> findAvailableRooms(int id);
}
