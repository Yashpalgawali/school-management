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
import com.example.demo.entity.Student;
import com.example.demo.service.IStudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {

	private final IStudentService studserv;
	
	@PostMapping("/")
	public ResponseEntity<ResponseDto> saveStudent(@Valid @RequestBody Student student) {
		
		studserv.saveStudent(student);
		
		return ResponseEntity.status(HttpStatus.CREATED)
			   .body(new ResponseDto(HttpStatus.CREATED.toString(), "Student "+student.getStudentFirstName()+" " + student.getStudentLastName()+" is saved successfully"));
		
	}
	
	@PutMapping("/")
	public ResponseEntity<ResponseDto> updateStudent(@Valid @RequestBody Student student) {
		
		studserv.updateStudent(student);
		
		return ResponseEntity.status(HttpStatus.OK)
			   .body(new ResponseDto(HttpStatus.OK.toString(), "Student "+student.getStudentFirstName()+" " + student.getStudentLastName()+" is updated successfully"));
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Student>> getAllStudents() {
		
		var student = studserv.getAllStudents();		
		return ResponseEntity.status(HttpStatus.OK).body(student);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		
		Student student = studserv.getStudentById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(student);
		
	}
	
	
	
	@GetMapping("/aadhar/{id}")
	public ResponseEntity<Student> getStudentByAadhar(@PathVariable Long id) {
		
		Student student = studserv.getStudentByAadhar(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(student);
		
	}
	
	@GetMapping("/registration/number/{id}")
	public ResponseEntity<Student> getStudentByRegistrationNUmber(@PathVariable Long id) {
		
		Student student = studserv.getStudentByAadhar(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(student);
		
	}
}
