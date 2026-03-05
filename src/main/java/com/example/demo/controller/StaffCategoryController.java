package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.StaffCategory;
import com.example.demo.service.IStaffCategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("staffcategory")
@RequiredArgsConstructor
public class StaffCategoryController {

	private final IStaffCategoryService staffcategoryserv;
	
	@PostMapping("/")
	public ResponseEntity<ResponseDto> savestaffcategory(@Valid @RequestBody StaffCategory staffcategory) {
		staffcategoryserv.saveStaffCategory(staffcategory);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.toString(), "staffcategory "+staffcategory.getStaffCategory()+" is created successfully"));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StaffCategory> retrieveStaffcategoryById(@PathVariable Long id) {
		var desigObject = staffcategoryserv.retrieveStaffCategoryById(id);
		return ResponseEntity.status(HttpStatus.OK).body(desigObject);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<StaffCategory>> getAllStaffCategories() {
		var desigList = staffcategoryserv.getAllCategoryStaff();
		return ResponseEntity.status(HttpStatus.OK).body(desigList);
	}
	
	@PutMapping("/")
	public ResponseEntity<ResponseDto> updatestaffcategory(@Valid @RequestBody StaffCategory staffcategory) {
		staffcategoryserv.updateStaffCategory(staffcategory);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.toString(), "staffcategory "+staffcategory.getStaffCategory()+" is updated successfully"));
	}
}
