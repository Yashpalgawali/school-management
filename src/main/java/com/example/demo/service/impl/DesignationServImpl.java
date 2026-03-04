package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Designation;
import com.example.demo.exception.GlobalException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ResourceNotModifiedException;
import com.example.demo.repository.DesignationRepository;
import com.example.demo.service.IDesignationService;

import lombok.RequiredArgsConstructor;

@Service("desigserv")
@RequiredArgsConstructor
public class DesignationServImpl implements IDesignationService {

	private final DesignationRepository desigrepo;
	
	@Override
	public void saveDesignation(Designation designation) {

		Designation savedDesignation = desigrepo.save(designation);
		if(savedDesignation == null) {
			 throw new GlobalException("Designation "+designation.getDesignation()+" is not saved");
		}
	}

	@Override
	public Designation retrieveDesignationById(Long id) {
		
		return desigrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Designation for given ID "+id));
	}

	@Override
	public List<Designation> getAllDesignations() {

		var desiglist = desigrepo.findAll();
		if(desiglist.size() > 0 )
			return desiglist;
		throw new ResourceNotFoundException("No Designations found");
	}

	@Override
	public void updateDesignation(Designation designation) {
		int res = desigrepo.updateDesignation(designation.getDesignationId(), designation.getDesignation());

		if(res<=0) {
			throw new ResourceNotModifiedException("Designation "+designation.getDesignation()+" is not updated");
		}
	}
}
