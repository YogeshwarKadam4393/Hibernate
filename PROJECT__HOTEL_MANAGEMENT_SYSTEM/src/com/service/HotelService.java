package com.service;

import java.util.List;
import com.entity.Hotel;

public interface HotelService {
	 
   public void addHotel();

   public void updateHotel(int id);
    
   public void deleteHotel(int id);
   
   public Hotel findHotelById(int id);
   
    
   public List<Hotel> getAllHotels();

   
   public List<Hotel> searchHotelsByCity(String city);

    
   public List<Hotel> findHotelsByRating(String rating);

}
