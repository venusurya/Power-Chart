package com.ty.com.ty.springboot_hospital_eb9.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class MedOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "MedOrder Name Should Not be Null")
	@NotNull(message = "MedOrder Name Sholud Not Be Blank")
	@NotBlank(message = " MedOrder Name is mandatory")
	private String name;

	@Min(value = 1, message = "Invalid Age")
	private int age;

	@NotNull(message = "Description  Should Not be Null")
	@NotBlank(message = "Description is mandatory")
	@NotEmpty(message = "Description Should Not Be Empty")
	private String Description;

	private LocalDateTime time = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));

	@ManyToOne
	private Encounter encounter;
}
