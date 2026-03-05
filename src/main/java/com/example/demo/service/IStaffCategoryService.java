package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.StaffCategory;

public interface IStaffCategoryService {

	public void saveStaffCategory(StaffCategory category);
	
	public StaffCategory retrieveStaffCategoryById(Long id);
	
	public List<StaffCategory> getAllCategoryStaff();
	
	public void updateStaffCategory(StaffCategory category);
}
