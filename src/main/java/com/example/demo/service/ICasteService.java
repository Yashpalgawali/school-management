package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Caste;

public interface ICasteService {

	public void saveCaste(Caste caste);
	
	public Caste retrieveCasteById(Long id);
	
	public List<Caste> getAllCastes();	
	
	public void updateCaste(Caste caste);
}
