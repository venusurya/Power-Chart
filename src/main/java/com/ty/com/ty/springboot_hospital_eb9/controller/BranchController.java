package com.ty.com.ty.springboot_hospital_eb9.controller;

import java.util.List;

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

import com.ty.com.ty.springboot_hospital_eb9.dao.BranchDao;
import com.ty.com.ty.springboot_hospital_eb9.dto.Branch;
import com.ty.com.ty.springboot_hospital_eb9.responseStriucture.ResponseStructure;
import com.ty.com.ty.springboot_hospital_eb9.service.BranchService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchServic;

	@Autowired
	private BranchDao branchDao;

	@PostMapping("/branch")
	@ApiOperation(value = "save Branch", notes = "Api is used to save Branch with given Hospital id")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Created "),
			@ApiResponse(code = 404, message = "Id not Found for the given Hospital Id") })
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody @Valid Branch branch, @RequestParam int hid,
			@RequestParam int aid) {
		return branchServic.saveBranch(branch, hid, aid);
	}

	@PutMapping("/branch")
	@ApiOperation(value = "Update Branch", notes = "Api is used to Update Branch with given Branch id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sucessfully Branch Is Updated"),
			@ApiResponse(code = 404, message = "Id not Found for the given Branch Id") })
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody @Valid Branch branch, @RequestParam int id) {
		return branchServic.updateBranch(branch, id);
	}

	@DeleteMapping("/branch")
	@ApiOperation(value = "Delete Branch", notes = "Api is used to  Delete Branch with given Branch id")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Branch Is Deleted"),
			@ApiResponse(code = 404, message = "Id not Found for the given Branch Id") })
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int id) {
		return branchServic.deleteBranch(id);
	}

	@ApiOperation(value = "Get Branch", notes = "Api is used to  Get the  Branch with given Branch id")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Branch Is Found"),
			@ApiResponse(code = 404, message = "Id not Found for the given Branch Id") })
	@GetMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> getBranch(@RequestParam int id) {
		return branchServic.getBranch(id);
	}

	@ApiOperation(value = "Get All  Branch", notes = "Api is used to  Get All  Branchs")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Found All Branches"),
			@ApiResponse(code = 404, message = "Id not Found for the given Branch Id") })
	@GetMapping("/branchall")
	public List<Branch> getBranch() {
		return branchDao.getAllBranches();

	}

	@GetMapping("/gethospital")
	@ApiOperation(value = "Get All  Branchs", notes = "Api is used to  Get All  Branchs With Given Hospital Id")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Found All Branches Mappped With Hospita Id"),
			@ApiResponse(code = 404, message = "Id not Found for the given Branch Id") })
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospitalId(@RequestParam int id) {
		return branchServic.getBranchByHospital(id);
	}

}
