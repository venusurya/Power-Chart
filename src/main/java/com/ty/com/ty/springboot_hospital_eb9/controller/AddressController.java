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

import com.ty.com.ty.springboot_hospital_eb9.dto.Address;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;
import com.ty.com.ty.springboot_hospital_eb9.service.AddressService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressController {

	@Autowired
	private AddressService addresService;

	@PostMapping("/address")
	@ApiOperation(value = "save Address", notes = "Api is used to save Address")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sucessfully Created ") })
	public ResponseEntity<ResponseStructure<Address>> saveAddress( @RequestBody @Valid Address address) {
		return addresService.saveAddress(address);
	}

	@PutMapping("/address")
	@ApiOperation(value = "Update Address", notes = "Api is used to Update Address")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Updated "),
			@ApiResponse(code = 404, message = "Id not Found for the given Address  Id") })
	public ResponseEntity<ResponseStructure<Address>> updateHospital(@RequestParam int id,
			@RequestBody @Valid Address address) {
		return addresService.updateAddress(id, address);
	}

	@DeleteMapping("/address")
	@ApiOperation(value = "Delete  Address", notes = "Api is used to Delete Address")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Deleted "),
			@ApiResponse(code = 404, message = "Id not Found for the given Address  Id") })
	public ResponseEntity<ResponseStructure<Address>> deletehospital(@RequestParam int id) {
		return addresService.deleteAddress(id);
	}

	@GetMapping("/address")
	@ApiOperation(value = "Get  Address", notes = "Api is used to Get Address")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully found Address"),
			@ApiResponse(code = 404, message = "Id not Found for the given Address  Id") })
	public ResponseEntity<ResponseStructure<Address>> getById(@RequestParam int id) {
		return addresService.getById(id);
	}

}
