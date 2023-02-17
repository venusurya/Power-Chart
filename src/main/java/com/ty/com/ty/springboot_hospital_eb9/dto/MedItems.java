package com.ty.com.ty.springboot_hospital_eb9.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class MedItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message=" Medcine name  Should Not be Null")
	@NotBlank(message = "Medcine name is mandatory")
	@NotEmpty(message="medcine Name Should Not Be Blank")
	private String medcine_name;
	
	@Min(value = 1, message = "Mandatory to Specify The No Of Pills")
	private int no_of_pills;
	
	@ManyToOne
	private MedOrder medOrder;
}
