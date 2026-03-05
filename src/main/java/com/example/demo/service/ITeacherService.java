package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Teacher;

public interface ITeacherService {

	public void saveTeacher(Teacher teacher);
	
	public Teacher retrieveTeacherById(Long id);
	
	public List<Teacher> getAllTeachers();
	
	public void updateTeacher(Teacher teacher);
	
}
