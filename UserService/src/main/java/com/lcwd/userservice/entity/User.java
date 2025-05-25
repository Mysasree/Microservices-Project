package com.lcwd.userservice.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User 
{
	@Id
	private String uId;
	private String uname;
	private String uemail;
	private String uabout;
	
	@Transient
	List<Rating> ratings = new ArrayList<>();
	
}
