package com.lcwd.hotelservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotel_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Hotel
{
	@Id
	private String hotelId;
	private String hname;
	private String hlocation;
	private String habout;
}
