package com.lcwd.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Hotel
{
	private String hotelId;
	private String hname;
	private String hlocation;
	private String habout;
}
