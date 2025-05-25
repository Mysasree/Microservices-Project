package com.lcwd.userservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.userservice.entity.User;
import com.lcwd.userservice.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User userObj = userService.saveUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED).ok(userObj);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers()
	{
		return new ResponseEntity<>(HttpStatus.OK).ok(userService.getAllUsers());
	}
	
	int retry_count=1;
	
	@GetMapping("/{userId}")
//	@CircuitBreaker(name = "ratingHotelCircuitBreaker",fallbackMethod = "ratingHotelFallBack")
//	@Retry(name = "ratingHotelRetry",fallbackMethod = "ratingHotelFallBack")
	@RateLimiter(name = "ratingHotelRateLimiter",fallbackMethod = "ratingHotelFallBack")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId)
	{
		logger.info("Retry Count : {}",retry_count);
		retry_count++;
		return new ResponseEntity<>(HttpStatus.OK).ok(userService.getSingleUser(userId));
	}
	
	public ResponseEntity<User> ratingHotelFallBack(String userId,Exception e)
	{
		logger.info("FallBack is executed because service is down : "+e.getMessage());
		User user = User.builder()
				.uId("1234")
				.uname("Dummy")
				.uemail("dummy@gmail.com")
				.uabout("No about for dummy user")
				.build();
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
