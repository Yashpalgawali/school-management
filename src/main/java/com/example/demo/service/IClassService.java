package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Class;

public interface IClassService {

	public void saveClass(Class classObj);

	public Class retrieveClassByID(Long id);

	public List<Class> retrieveAllClasses();

	public void updateClass(Class classObj);
}
