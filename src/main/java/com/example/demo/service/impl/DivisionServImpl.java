package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Division;
import com.example.demo.exception.GlobalException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DivisionRepository;
import com.example.demo.service.IDivisionService;

import lombok.RequiredArgsConstructor;

@Service("divserv")
@RequiredArgsConstructor
public class DivisionServImpl implements IDivisionService {

	private final DivisionRepository divisionrepo;
	
	@Override
	public void saveDivision(Division division) {
		
		var savedDivision = divisionrepo.save(division);
		if(savedDivision == null)
		{
			throw new GlobalException("Division "+division.getDivision()+" is not saved");
		}
	}

	@Override
	public Division retrieveDivisionById(Long id) {
		return divisionrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Division found for given ID "+id));
	}

	@Override
	public List<Division> getAllDivisions() {

		var divList = divisionrepo.findAll();
		if(divList.size()>0) {
			return divList;
		}
		throw new ResourceNotFoundException("No Divisions are Found");
	}

	@Override
	public void updateDivision(Division division) {

		int res = divisionrepo.updateDivision(division.getDivisionId(), division.getDivision(), division.getClassObj().getClassId() );

		if(res<0) {
			throw new GlobalException("Division "+division.getDivision()+" is not updated");
		}

	}

}
