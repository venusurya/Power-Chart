package com.ty.com.ty.springboot_hospital_eb9.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Person Name Should Not be Null")
	@NotEmpty(message = "person Name Should Not Be Empty")
	@NotBlank(message = "Person name is mandatory")
	private String name;
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid Phone Number")
	private String phone;

	@Pattern(regexp = "^(?=.@)[A-Za-z0-9_-]+(.[A-Za-z0-9_-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9-]+)*(.[A-Za-z]{2,}){1,64}$")
	@NotBlank(message = "Email Should Not  Be Blank")
	private String email;

}
