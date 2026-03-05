package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.StaffCategory;
import com.example.demo.exception.GlobalException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StaffCategoryRepository;
import com.example.demo.service.IStaffCategoryService;

import lombok.RequiredArgsConstructor;

@Service("staffcategoryserv")
@RequiredArgsConstructor
public class StaffCategoryServImpl implements IStaffCategoryService {

	private final StaffCategoryRepository staffcategoryrepo;
	
	@Override
	public void saveStaffCategory(StaffCategory category) {
			
		var savedObj = staffcategoryrepo.save(category);
		if(savedObj == null)
			throw new GlobalException("Staff Category "+category.getStaffCategory()+" is not saved");
	}

	@Override
	public StaffCategory retrieveStaffCategoryById(Long id) {
		
		return staffcategoryrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No staff Category found for given ID "+id));
	}

	@Override
	public List<StaffCategory> getAllCategoryStaff() {
		var list = staffcategoryrepo.findAll();
		if(list.size()>0)
			return list;
		throw new ResourceNotFoundException("No Staff Categories found");
	}

	@Override
	@Transactional
	public void updateStaffCategory(StaffCategory category) {
		int res = staffcategoryrepo.updateStaffCategory(category.getStaffCategoryId(), category.getStaffCategory());
		if(res<0) {
			throw new GlobalException("Staff Category "+category.getStaffCategory()+" is not updated ");
		}
	}

}
