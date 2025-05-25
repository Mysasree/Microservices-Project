package com.lcwd.ratingservice.service;

import java.util.List;

import com.lcwd.ratingservice.entity.Rating;

public interface RatingService 
{
	public Rating saveRating(Rating rating);
	
	public List<Rating> getAllRatings();
	
	public List<Rating> getRatingByUserId(String userId);
	
	public List<Rating> getRatingByHotelId(String hotelId);
}
