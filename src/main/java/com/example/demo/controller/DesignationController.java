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
import com.example.demo.entity.Designation;
import com.example.demo.service.IDesignationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("designation")
@RequiredArgsConstructor
public class DesignationController {

	private final IDesignationService desigserv;
	
	@PostMapping("/")
	public ResponseEntity<ResponseDto> saveDesignation(@Valid @RequestBody Designation designation) {
		desigserv.saveDesignation(designation);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.toString(), "Designation "+designation.getDesignation()+" is created successfully"));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Designation> retrieveDesignationById(@PathVariable Long id) {
		var desigObject = desigserv.retrieveDesignationById(id);
		return ResponseEntity.status(HttpStatus.OK).body(desigObject);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Designation>> getAllDesignations() {
		var desigList = desigserv.getAllDesignations();
		return ResponseEntity.status(HttpStatus.OK).body(desigList);
	}
	
	@PutMapping("/")
	public ResponseEntity<ResponseDto> updateDesignation(@Valid @RequestBody Designation designation) {
		desigserv.saveDesignation(designation);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.toString(), "Designation "+designation.getDesignation()+" is updated successfully"));
	}
}
