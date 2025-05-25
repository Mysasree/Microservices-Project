package com.lcwd.hotelservice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotelservice.entity.Hotel;
import com.lcwd.hotelservice.exceptions.HotelNotFoundException;
import com.lcwd.hotelservice.repository.HotelRepository;
import com.lcwd.hotelservice.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService
{
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel saveHotel(Hotel hotel)
	{
		String randomHotelId = UUID.randomUUID().toString();
		hotel.setHotelId(randomHotelId);
		Optional<Hotel> hotelOpt = hotelRepository.findById(hotel.getHotelId());
		if(hotelOpt.isEmpty())
		{
			return hotelRepository.save(hotel);
		}
		else
		{
			return hotelOpt.get();
		}
	}

	@Override
	public List<Hotel> getAllHotels()
	{
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getSingleHotel(String hotelId) 
	{
		return hotelRepository.findById(hotelId).orElseThrow(()->new HotelNotFoundException("Hotel is not found with hotelId : "+hotelId));
	}
	
}
