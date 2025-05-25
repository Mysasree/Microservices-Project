package com.lcwd.userservice.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.userservice.entity.Hotel;
import com.lcwd.userservice.entity.Rating;
import com.lcwd.userservice.entity.User;
import com.lcwd.userservice.exceptions.UserNotFoundException;
import com.lcwd.userservice.feignclient.HotelFeignClient;
import com.lcwd.userservice.repository.UserRepository;
import com.lcwd.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelFeignClient hotelFeignClient;
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Override
	public User saveUser(User user) 
	{
		String randomUserId = UUID.randomUUID().toString();
		user.setUId(randomUserId);
		
		Optional<User> userOpt = userRepository.findById(randomUserId);
		if(userOpt.isEmpty())
		{
			return userRepository.save(user);
		}
		else
		{
			return userOpt.get();
		}
		
	}

	@Override
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}

	@Override
	public User getSingleUser(String userId) 
	{
		User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("user is not found with userId : "+userId));
		
		//Getting the response in an array
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/user/"+userId, Rating[].class);
		
		//converting array to List
		List<Rating> ratings = Arrays.asList(ratingsOfUser);
		
		//Fetching Hotel information for each rating - by using Rest Template
/*		List<Rating> ratingsList = ratings.stream().map(rating -> {
			
											Hotel hotelInfo = restTemplate.getForObject("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
											rating.setHotel(hotelInfo);
											return rating;
											}).toList();    */
		
		
		//Fetching Hotel information for each rating - by using Feign Client		
		List<Rating> ratingsList = ratings.stream().map(rating ->{
																	Hotel hotelInfo = hotelFeignClient.getSingleHotel(rating.getHotelId());
																	rating.setHotel(hotelInfo);
																	return rating;
																}
														).toList();
		
		
		logger.info("Ratings Of User : {}",ratingsList);
		
		user.setRatings(ratingsList);
		
		return user;	
	}

}
