package com.example.demo.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Aisle;

@RequestMapping("/aisle")
public interface AisleServiceInt {
	
	@PostMapping("/")
	public ResponseEntity<Aisle> createAisle(Aisle reserve) throws Exception;

	@GetMapping("/")
	public ResponseEntity<List<Aisle>> getAisleList() throws Exception;
}
