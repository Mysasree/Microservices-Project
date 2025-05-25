package com.lcwd.hotelservice.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(value = HotelNotFoundException.class)
	public ResponseEntity handleHotelNotFoundException(HotelNotFoundException exception)
	{		
		Map<String,Object> map = new HashMap<>();
		map.put("message", exception.getMessage());
		map.put("success", true);
		map.put("httpStatus", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
	}
}
