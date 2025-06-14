package com.lcwd.ratingservice.controller;

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

import com.lcwd.ratingservice.entity.Rating;
import com.lcwd.ratingservice.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController 
{
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
	}

	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings() 
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) 
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) 
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
	}
}
