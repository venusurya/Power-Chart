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

import com.ty.com.ty.springboot_hospital_eb9.dto.MedItems;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;
import com.ty.com.ty.springboot_hospital_eb9.service.MedItemsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedItemsController {
	@Autowired
	private MedItemsService service;

	@PostMapping("/medItems")
	@ApiOperation(value = "save medItems", notes = "Api is used to save MedItems")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sucessfully Created"),
			@ApiResponse(code = 404, message = "Id NoT found For Given MedOrder Id") })
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(@RequestBody @Valid MedItems medItems,
			@RequestParam int medorderid) {
		return service.saveMedItems(medItems, medorderid);
	}

	@PutMapping("/medItems")
	@ApiOperation(value = "Update MedItems", notes = "Api is used to Update MedItems")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Updated"),
			@ApiResponse(code = 404, message = "Id not Found for the given MedItems Id") })
	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(@RequestBody @Valid MedItems medItems,
			@RequestParam int mid) {
		return service.updateMeditems(medItems, mid);
	}

	@DeleteMapping("/medItems")
	@ApiOperation(value = "Delete MedItems", notes = "Api is used to Delete MedItems")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Deleted"),
			@ApiResponse(code = 404, message = "Id not Found for the given MedItems Id") })
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(@RequestParam int mid) {
		return service.deleteMeditems(mid);
	}

	@GetMapping("/medItems")
	@ApiOperation(value = "Get MedItems", notes = "Api is used to Get MedItems")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Found"),
			@ApiResponse(code = 404, message = "Id not Found for the given MedItems Id") })
	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsById(@RequestParam int mid) {
		return service.getMeditemsById(mid);
	}
}
