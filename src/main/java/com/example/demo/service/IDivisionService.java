package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Division;

public interface IDivisionService {

	public void saveDivision(Division division);
	
	public Division retrieveDivisionById(Long id);
	
	public List<Division> getAllDivisions();
	
	public void updateDivision(Division division);
}
