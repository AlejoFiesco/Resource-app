package com.example.demo.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Aisle;

@RequestMapping("/aisle")
@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST})
public interface AisleServiceInt {
	
	@PostMapping("/")
	public ResponseEntity<Aisle> createAisle(@RequestBody Aisle aisle) throws Exception;

	@GetMapping("/")
	public ResponseEntity<List<Aisle>> getAisleList() throws Exception;
	
	@GetMapping("/{aisleId}")
	public ResponseEntity<Aisle> getAisleById(@PathVariable(value="aisleId") String aisleId) throws Exception;
}
