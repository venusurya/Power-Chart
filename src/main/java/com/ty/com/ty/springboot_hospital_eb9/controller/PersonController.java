package com.ty.com.ty.springboot_hospital_eb9.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.com.ty.springboot_hospital_eb9.dto.Person;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;
import com.ty.com.ty.springboot_hospital_eb9.service.PersonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;

	@PostMapping("/person")
	@ApiOperation(value = "Save Person", notes = "Api is used to Save Person")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Created") })
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody @Valid Person person) {
		return service.savePerson(person);
	}

	@PutMapping("/person")
	@ApiOperation(value = "Update Person", notes = "Api is used to Update Person")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Updated"),
			@ApiResponse(code = 404, message = "Id Not Found For Given Person Id") })
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestParam int id, @RequestBody @Valid Person person) {
		return service.updatePerson(id, person);
	}

	@DeleteMapping("/person")
	@ApiOperation(value = "Delete Person", notes = "Api is used to Delete Person")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Deleted"),
			@ApiResponse(code = 404, message = "Id Not Found For Given Person Id") })
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int id) {
		return service.deletePerson(id);
	}

	@GetMapping("/person")
	@ApiOperation(value = "Get Person", notes = "Api is used to Get Person")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Found"),
			@ApiResponse(code = 404, message = "Id Not Found For Given Person Id") })
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int id) {
		return service.getByPersonId(id);
	}
}
