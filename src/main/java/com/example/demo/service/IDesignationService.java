package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Designation;

public interface IDesignationService {

	public void saveDesignation(Designation designation);
	
	public Designation retrieveDesignationById(Long id);
	
	public List<Designation> getAllDesignations();
	
	public void updateDesignation(Designation designation);
}
