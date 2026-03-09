package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface IStudentService {
	
	public void saveStudent(Student student);
	
	public Student getStudentById(Long id);
	
	public Student getStudentByAadhar(Long aadhar);
	
	public Student getStudentByRegistrationNumber(String regnum);
	
	public List<Student> getAllStudents();
	
	public List<Student> getAllStudentsByClass(Long classId);
	
	public List<Student> getAllStudentsByTeacher(Long teacherId);
	
	public void updateStudent(Student student);
}
