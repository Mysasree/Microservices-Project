package com.lcwd.userservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.userservice.entity.Hotel;

@FeignClient(name = "HOTELSERVICE")
public interface HotelFeignClient 
{
	@GetMapping("/hotels/{hotelId}")
	public Hotel getSingleHotel(@PathVariable String hotelId);
}
