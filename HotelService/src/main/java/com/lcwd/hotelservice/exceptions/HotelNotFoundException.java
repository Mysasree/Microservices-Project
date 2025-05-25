package com.lcwd.hotelservice.exceptions;

public class HotelNotFoundException extends RuntimeException
{
	public HotelNotFoundException(String message)
	{
		super(message);
	}
}
