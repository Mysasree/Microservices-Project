package com.lcwd.hotelservice.service;

import java.util.List;

import com.lcwd.hotelservice.entity.Hotel;

public interface HotelService 
{
	public Hotel saveHotel(Hotel hotel);
	
	public List<Hotel> getAllHotels();
	
	public Hotel getSingleHotel(String hotelId);
}
