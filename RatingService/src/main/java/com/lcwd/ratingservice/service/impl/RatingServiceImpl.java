package com.lcwd.ratingservice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.ratingservice.entity.Rating;
import com.lcwd.ratingservice.repository.RatingRepository;
import com.lcwd.ratingservice.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService
{
	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating saveRating(Rating rating)
	{
		String randomRatingId = UUID.randomUUID().toString();
		rating.setRatingId(randomRatingId);
		Optional<Rating> ratingOpt = ratingRepository.findById(rating.getRatingId());
		if(ratingOpt.isEmpty())
		{
			return ratingRepository.save(rating);
		}
		else
		{
			return ratingOpt.get();
		}
	}

	@Override
	public List<Rating> getAllRatings()
	{
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) 
	{
		return ratingRepository.findRatingByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId)
	{
		return ratingRepository.findRatingByHotelId(hotelId);
	}

}
