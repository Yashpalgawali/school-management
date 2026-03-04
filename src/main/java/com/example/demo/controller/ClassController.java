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
import com.example.demo.entity.Class;
import com.example.demo.service.IClassService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("class")
@RequiredArgsConstructor
public class ClassController {

	private final IClassService classserv;
	
	@PostMapping("/")
	public ResponseEntity<ResponseDto> saveDesignation(@Valid @RequestBody Class classObj) {
		classserv.saveClass(classObj);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.toString(), "Class "+classObj.getClassName()+" is created successfully"));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Class> retrieveClassById(@PathVariable Long id) {
		var classObject = classserv.retrieveClassByID(id);
		return ResponseEntity.status(HttpStatus.OK).body(classObject );
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Class>> getAllClasses() {
		var classList = classserv.retrieveAllClasses();
		return ResponseEntity.status(HttpStatus.OK).body(classList);
	}
	
	@PutMapping("/")
	public ResponseEntity<ResponseDto> updateDesignation(@Valid @RequestBody Class classObj) {
		classserv.updateClass(classObj);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.toString(), "Class "+classObj.getClassName() +" is updated successfully"));
	}
}
