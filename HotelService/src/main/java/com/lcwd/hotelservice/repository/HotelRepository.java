package com.lcwd.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.hotelservice.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>
{

}
