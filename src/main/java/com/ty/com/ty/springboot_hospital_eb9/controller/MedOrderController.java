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

import com.ty.com.ty.springboot_hospital_eb9.dto.MedOrder;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;
import com.ty.com.ty.springboot_hospital_eb9.service.MedOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedOrderController {

	@Autowired
	private MedOrderService orderService;

	@PostMapping("/medorder")
	@ApiOperation(value = "save MedOrder", notes = "Api is used to save MedOrder")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sucessfully Created"),
			@ApiResponse(code = 404, message = "Id NoT found For Given Encounter Id") })
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody @Valid MedOrder medOrder,
			@RequestParam int eid) {
		return orderService.saveMedOrder(medOrder, eid);
	}

	@PutMapping("/medorder")
	@ApiOperation(value = "Update MedOrder", notes = "Api is used to Update MedOrder")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Updated"),
			@ApiResponse(code = 404, message = "Id not Found for the given MedOrder Id") })
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestBody @Valid MedOrder medOrder,
			@RequestParam int mid) {
		return orderService.updateMedOrder(medOrder, mid);
	}

	@DeleteMapping("/medorder")
	@ApiOperation(value = "Delete MedOrder", notes = "Api is used to Delete  MedOrder")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Deleted"),
			@ApiResponse(code = 404, message = "Id not Found for the given MedOrder Id") })
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(@RequestParam int mid) {
		return orderService.deleteMedOrder(mid);
	}

	@GetMapping("/medorder")
	@ApiOperation(value = "Get MedOrder", notes = "Api is used to Get MedOrder")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Found"),
			@ApiResponse(code = 404, message = "Id not Found for the given MedOrder Id") })
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(@RequestParam int mid) {
		return orderService.getMedOrderById(mid);
	}

}
