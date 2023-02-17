package com.ty.com.ty.springboot_hospital_eb9.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Reason  Should Not be Null")
	@NotBlank(message = "Reason is mandatory")
	@NotEmpty(message="Reason Must Should Be Mention It could not be Empty")
	private String reason;

	@Min(value = 1, message = "Invalid Price")
	private double cost;

	@ManyToOne
	private Person person;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Branch> branches;
}
