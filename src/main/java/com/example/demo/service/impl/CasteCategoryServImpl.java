package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CasteCategory;
import com.example.demo.exception.GlobalException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CasteCategoryRepository;
import com.example.demo.service.ICasteCategoryService;

import lombok.RequiredArgsConstructor;

@Service("castecategoryserv")
@RequiredArgsConstructor
public class CasteCategoryServImpl implements ICasteCategoryService {

	private final CasteCategoryRepository castecategoryrepo;
	
	@Override
	public void saveCasteCategory(CasteCategory category) {
		var savedObj = castecategoryrepo.save(category);
		if(savedObj==null) {
			throw new GlobalException("Caste Category "+category.getCasteCategory()+" is not saved");
		}
	}

	@Override
	public CasteCategory retrieveCasteCategoryById(Long id) {
		
		return castecategoryrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Caste Category found for ID "+id) );
	}

	@Override
	public List<CasteCategory> getAllCasteCategories() {
		var list = castecategoryrepo.findAll();
		if (list.size()>0) {
			return list;
		}
		else {
			throw new ResourceNotFoundException("No Caaste Categories found");
		}
	}

	@Override
	@Transactional
	public void updateCasteCategory(CasteCategory category) {
		int res = castecategoryrepo.updateCasteCategory(category.getCasteCategoryId(), category.getCasteCategory());
		if(res<0) {
			throw new GlobalException("Caste Category "+category.getCasteCategory()+" is not updated");
		}
	}

}
