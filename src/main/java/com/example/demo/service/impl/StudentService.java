package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Class;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.exception.GlobalException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.IClassService;
import com.example.demo.service.IStudentService;
import com.example.demo.service.ITeacherService;

import lombok.RequiredArgsConstructor;

@Service("studserv")
@RequiredArgsConstructor
public class StudentService implements IStudentService {

	private final StudentRepository studrepo;
	
	private final IClassService classServ;
	
	private final ITeacherService teacherserv;
	
	@Override
	public void saveStudent(Student student) {
		System.err.println("Student to be saved \n "+student.toString());
		
		Optional<Student> found = studrepo.findByAadharNumberOrRegistrationNumber(student.getAadharNumber(), student.getRegistrationNumber());
		if(found.isPresent()) {
			if(student.getAadharNumber()==found.get().getAadharNumber()) {				
				throw new GlobalException("Student with the Aadhar number "+student.getAadharNumber()+" is already registered");
			}
			if(student.getRegistrationNumber().equals(found.get().getRegistrationNumber())) {
				throw new GlobalException("Student with the Registration Number "+student.getRegistrationNumber()+" is already registered");
			}
		}
		else {
			Student savedStudent = studrepo.save(student);
			if(savedStudent == null)
				throw new GlobalException("Student "+student.getStudentFirstName()+" "+student.getStudentLastName()+" is not saved"); 
		}
	}

	@Override
	public Student getStudentById(Long id) {

		return studrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Student found for given ID "+id));
	}

	@Override
	public Student getStudentByAadhar(Long aadhar) {
	 
		return studrepo.findByAadharNumber(aadhar).orElseThrow(()->new ResourceNotFoundException("No Student found for given Aadhar number"));
	}

	@Override
	public Student getStudentByRegistrationNumber(String regnum) {

		return studrepo.findByRegistrationNumber(regnum).orElseThrow(()-> new ResourceNotFoundException("No Student record found for given Registration ID "+regnum));
	}

	@Override
	public List<Student> getAllStudents() {
		var studList = studrepo.findAll();
		if(studList.size()>0)
			return studList;
		else {
			throw new ResourceNotFoundException("No Student(s) found");
		}
	}	

	@Override
	public List<Student> getAllStudentsByClass(Long classId) {
		
		Class classObj = classServ.retrieveClassByID(classId);

		List<Student> studList = studrepo.findByClassObj(classObj);
		if(studList.size() > 0) {
			return studList;
		}
		else {
			throw new ResourceNotFoundException("no Student(s) found in the class "+classObj.getClassName());
		}
	}

	@Override
	public List<Student> getAllStudentsByTeacher(Long teacherId) {
		
		Teacher teacherObj = teacherserv.retrieveTeacherById(teacherId);
		
		var studList = studrepo.findByClassObj(teacherObj.getClassObj());
		if(studList.size() > 0) {
			return studList;
		}
		else {
			throw new ResourceNotFoundException("No Student(s) found");
		}
	}

	@Override
	@Transactional
	public void updateStudent(Student student) {
		int res = studrepo.updateStudent(student.getStudentId(), student.getStudentFirstName(), student.getStudentMiddleName(), student.getStudentLastName(), student.getContactNumber(), student.getAadharNumber(), student.getRegistrationNumber(), student.getStudentAddress());
		if(res<0)
			throw new GlobalException("Details of Student "+student.getStudentFirstName()+" "+student.getStudentLastName()+" is not updated");
	}

}
