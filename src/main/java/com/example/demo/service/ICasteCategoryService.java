package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CasteCategory;

public interface ICasteCategoryService {

	public void saveCasteCategory(CasteCategory category);
	
	public CasteCategory retrieveCasteCategoryById(Long id);
	
	public List<CasteCategory> getAllCasteCategories();
	
	public void updateCasteCategory(CasteCategory category);
}
