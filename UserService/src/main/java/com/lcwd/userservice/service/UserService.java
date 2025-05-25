package com.lcwd.userservice.service;

import java.util.List;

import com.lcwd.userservice.entity.User;

public interface UserService
{
	//save user
	public User saveUser(User user);
	
	//Get All users
	public List<User> getAllUsers();
	
	//Get Single User
	public User getSingleUser(String userId);
}
