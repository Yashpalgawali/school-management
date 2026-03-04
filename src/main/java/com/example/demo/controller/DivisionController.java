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
import com.example.demo.entity.Division;
import com.example.demo.service.IDivisionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("division")
@RequiredArgsConstructor
public class DivisionController {

	private final IDivisionService devisionserv;
	
	@PostMapping("/")
	public ResponseEntity<ResponseDto> saveDesignation(@Valid @RequestBody Division division) {
		devisionserv.saveDivision(division);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.toString(), "Designation "+division.getDivision()+" is created successfully"));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Division> retrieveDesignationById(@PathVariable Long id) {
		var divisionObject = devisionserv.retrieveDivisionById(id);
		return ResponseEntity.status(HttpStatus.OK).body(divisionObject);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Division>> getAllDivisions() {
		var divisionList = devisionserv.getAllDivisions();
		return ResponseEntity.status(HttpStatus.OK).body(divisionList);
	}
	
	@PutMapping("/")
	public ResponseEntity<ResponseDto> updateDesignation(@Valid @RequestBody Division division) {
		devisionserv.updateDivision(division);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.toString(), "Division "+division.getDivision()+" is updated successfully"));
	}
}
