package com.lcwd.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotelservice.entity.Hotel;
import com.lcwd.hotelservice.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController 
{
	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
	{
		Hotel hotelObj = hotelService.saveHotel(hotel);
		return new ResponseEntity<>(HttpStatus.CREATED).ok(hotelObj);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels()
	{
		return new ResponseEntity<>(HttpStatus.OK).ok(hotelService.getAllHotels());
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId)
	{
		return new ResponseEntity<>(HttpStatus.OK).ok(hotelService.getSingleHotel(hotelId));
	}
}
