package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.CasteCategory;
import com.example.demo.service.ICasteCategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("castecategory")
@RequiredArgsConstructor
public class CasteCategoryController {

	private final ICasteCategoryService castecategoryserv;
	
	@PostMapping("/")
	public ResponseEntity<ResponseDto> savecastecategory(@Valid @RequestBody CasteCategory castecategory) {
		castecategoryserv.saveCasteCategory(castecategory);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.toString(), "Caste Category "+castecategory.getCasteCategory()+" is created successfully"));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CasteCategory> retrieveCastecategoryById(@PathVariable Long id) {
		var desigObject = castecategoryserv.retrieveCasteCategoryById(id);
		return ResponseEntity.status(HttpStatus.OK).body(desigObject);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CasteCategory>> getAllCasteCategories() {
		var casteList = castecategoryserv.getAllCasteCategories();
				
		return ResponseEntity.status(HttpStatus.OK).body(casteList );
	}
	
	@PutMapping("/")
	public ResponseEntity<ResponseDto> updatecastecategory(@Valid @RequestBody CasteCategory castecategory) {
		castecategoryserv.updateCasteCategory(castecategory);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.toString(), "Caste Category "+castecategory.getCasteCategory()+" is updated successfully"));
	}
}
