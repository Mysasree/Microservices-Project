package com.lcwd.ratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.ratingservice.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>
{
	List<Rating> findRatingByUserId(String userId);
	
	List<Rating> findRatingByHotelId(String HotelId);
}
