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
import com.example.demo.entity.Caste;
import com.example.demo.service.ICasteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("caste")
@RequiredArgsConstructor
public class CasteController {

	private final ICasteService casteserv;
	
	@PostMapping("/")
	public ResponseEntity<ResponseDto> saveCaste(@Valid @RequestBody Caste caste ){
		
		casteserv.saveCaste(caste);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.toString(), "Caste "+caste.getCaste()+" is created successfully"));
	}
	
	@PutMapping("/")
	public ResponseEntity<ResponseDto> updateCaste(@Valid @RequestBody Caste caste ){
		
		casteserv.updateCaste(caste);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.toString(), "Caste "+caste.getCaste()+" is updated successfully"));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Caste> retrieveCasteById(@PathVariable Long id){
		
		var caste = casteserv.retrieveCasteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(caste);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Caste>> getAllCastes(){
		
		var casteList = casteserv.getAllCastes();
		return ResponseEntity.status(HttpStatus.OK).body(casteList);
	}
}
