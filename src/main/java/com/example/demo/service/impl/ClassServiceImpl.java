package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Class;
import com.example.demo.exception.GlobalException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ResourceNotModifiedException;
import com.example.demo.repository.ClassRepository;
import com.example.demo.service.IClassService;

import lombok.RequiredArgsConstructor;

@Service("classserv")
@RequiredArgsConstructor
public class ClassServiceImpl implements IClassService {

	private final ClassRepository classrepo;

	@Override
	public void saveClass(Class classObj) {

		Class savedObj = classrepo.save(classObj);
		if (savedObj == null) {
			throw new GlobalException("Class " + classObj.getClassName() + " is not saved");
		}
	}

	@Override
	public Class retrieveClassByID(Long id) {
		return classrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Class is found "));
	}

	@Override
	public List<Class> retrieveAllClasses() {
		var classList = classrepo.findAll();
		if (classList.size() > 0) {
			return classList;
		}
		throw new ResourceNotFoundException("No classes found");
	}

	@Override
	@Transactional
	public void updateClass(Class classObj) {
		int res = classrepo.updateClass(classObj.getClassId(), classObj.getClassName());
		if (res < 0) {
			throw new ResourceNotModifiedException("Class " + classObj.getClassName() + " is not updated");
		}
	}

}
