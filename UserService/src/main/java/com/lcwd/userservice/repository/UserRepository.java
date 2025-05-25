package com.lcwd.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
