package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Caste;
import com.example.demo.exception.GlobalException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CasteRepository;
import com.example.demo.service.ICasteCategoryService;
import com.example.demo.service.ICasteService;

import lombok.RequiredArgsConstructor;

@Service("casteserv")
@RequiredArgsConstructor
public class CasteServImpl implements ICasteService {

	private final CasteRepository casterepo;

	private final ICasteCategoryService castecategoryserv;

	@Override
	public void saveCaste(Caste caste) {

		castecategoryserv.retrieveCasteCategoryById(caste.getCasteCategory().getCasteCategoryId());
		var savedObj = casterepo.save(caste);
		if (savedObj == null) {
			throw new GlobalException("Caste " + caste.getCaste() + " is not saved");
		}

	}

	@Override
	public Caste retrieveCasteById(Long id) {

		return casterepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Caste found for given ID " + id));
	}

	@Override
	public List<Caste> getAllCastes() {
		var casteList = casterepo.findAll();
		if (casteList.size() > 0)
			return casteList;
		throw new ResourceNotFoundException("No Caste(s) Found");
	}

	@Override
	@Transactional
	public void updateCaste(Caste caste) {
		int res = casterepo.updateCaste(caste.getCasteId(), caste.getCaste(),
				caste.getCasteCategory().getCasteCategoryId());
		if (res < 0) {
			throw new GlobalException("Caste " + caste.getCaste() + " is not updated");
		}
	}

}
