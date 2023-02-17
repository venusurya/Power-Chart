package com.ty.com.ty.springboot_hospital_eb9.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Location Should Not Be Empty")
	@NotNull(message = "Location Should Not Be Null")
	@NotBlank(message = "Location Is Mandatory")
	private String location;

	@NotEmpty(message = "Street Should Not Be Empty")
	@NotNull(message = "Street Should Not Be Null")
	@NotBlank(message = "Street Is Mandatory")
	private String Street;

	@NotEmpty(message = "Road_cross Should Not Be Empty")
	@NotNull(message = "Road_Cross Should Not Be Null")
	@NotBlank(message = "Road_Cross Is Mandatory")
	private String road_cross;

	@Pattern(regexp = "^[0-9]{6}$", message = "length must be 6")
	private String pincode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getRoad_cross() {
		return road_cross;
	}

	public void setRoad_cross(String road_cross) {
		this.road_cross = road_cross;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
