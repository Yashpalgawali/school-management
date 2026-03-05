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
import com.example.demo.entity.Teacher;
import com.example.demo.service.ITeacherService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("teacher")
@RequiredArgsConstructor
public class TeacherController {

	private final ITeacherService teacherserv;
	
	@PostMapping("/")
	public ResponseEntity<ResponseDto> saveTeacher(@Valid @RequestBody Teacher teacher) {
		teacherserv.saveTeacher(teacher);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.toString(), "Teacher "+teacher.getTeacherName()+" is created successfully"));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Teacher> retrieveDesignationById(@PathVariable Long id) {
		var teacherObject = teacherserv.retrieveTeacherById(id);
		return ResponseEntity.status(HttpStatus.OK).body(teacherObject);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Teacher>> getAllDesignations() {
		var teacherList = teacherserv.getAllTeachers();				
		return ResponseEntity.status(HttpStatus.OK).body(teacherList);
	}
	
	@PutMapping("/")
	public ResponseEntity<ResponseDto> updateDesignation(@Valid @RequestBody Teacher teacher) {
		teacherserv.updateTeacher(teacher);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.toString(), "Teacher "+teacher.getTeacherName()+" is updated successfully"));
	}
}
