package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Teacher;
import com.example.demo.exception.GlobalException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.ITeacherService;

import lombok.RequiredArgsConstructor;

@Service("teacherserv")
@RequiredArgsConstructor
public class TeacherServImpl implements ITeacherService {

	private final TeacherRepository teacherrepo;
	
	@Override
	public void saveTeacher(Teacher teacher) {
		
		Teacher savedTeacher = teacherrepo.save(teacher);
		if(savedTeacher == null)
			throw new GlobalException("Teacher "+teacher.getTeacherName()+" is not saved");
	}

	@Override
	public Teacher retrieveTeacherById(Long id) {

		return teacherrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("No Teacher found for given Id "+id));
	}

	@Override
	public List<Teacher> getAllTeachers() {
		var teacherList = teacherrepo.findAll();
		if(teacherList.size()>0)
			return teacherList;
		else
			throw new ResourceNotFoundException("No Teacher(s) found");
	}

	@Override
	@Transactional
	public void updateTeacher(Teacher teacher) {
		
		int res = teacherrepo.updateTeacher(teacher.getTeacherId(), teacher.getTeacherName(), teacher.getClassObj().getClassId() , 
				teacher.getStaffCategory().getStaffCategoryId());
		if(res < 0 )	
			throw new GlobalException("Teacher "+teacher.getTeacherName()+" is not updated");
	}

}
