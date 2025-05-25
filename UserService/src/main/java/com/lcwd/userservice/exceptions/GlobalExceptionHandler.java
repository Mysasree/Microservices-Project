package com.lcwd.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ApiResponse> handleUserNotFoundException(UserNotFoundException exception)
	{		
		return new ResponseEntity<ApiResponse>(ApiResponse.builder()
				.message(exception.getMessage())
				.Success(true)
				.httpStatus(HttpStatus.NOT_FOUND)
				.build(), HttpStatus.NOT_FOUND);
	}
}
