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

import com.ty.com.ty.springboot_hospital_eb9.dto.Encounter;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;
import com.ty.com.ty.springboot_hospital_eb9.service.EncounterService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {
	@Autowired
	private EncounterService encounterService;

	@PostMapping("/encounter")
	@ApiOperation(value = "Save Encounter", notes = "Api is used to save Encounter with given branch Id And person Id")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Created  "),
			@ApiResponse(code = 404, message = "Id not Found for either the given Branch Id or Person Id") })
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody  @Valid Encounter encounter,
			@RequestParam int pid, @RequestParam int bid) {
		return encounterService.saveEncounter(encounter, pid, bid);
	}

	@PutMapping("/encounter")
	@ApiOperation(value = "Update  Encounter", notes = "Api is used to update Encounter with given Encounter Id")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Updated"),
			@ApiResponse(code = 404, message = "Id not Found for the given Encounter Id") })
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestBody @Valid Encounter encounter,
			@RequestParam int eid, @RequestParam int bid) {
		return encounterService.updateEncounter(encounter, eid, bid);
	}

	@DeleteMapping("/encounter")
	@ApiOperation(value = "Delete  Encounter", notes = "Api is used to delete Encounter with given Encounter Id")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Deleted"),
			@ApiResponse(code = 404, message = "Id not Found for the given Encounter Id") })
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int eid) {
		return encounterService.deleteEncounter(eid);
	}

	@GetMapping("/encounter")
	@ApiOperation(value = "Get  Encounter", notes = "Api is used to Get Encounter with given Encounter Id")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Found"),
			@ApiResponse(code = 404, message = "Id not Found for the given Encounter Id") })
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(@RequestParam int eid) {
		return encounterService.getEncounterById(eid);
	}

}
