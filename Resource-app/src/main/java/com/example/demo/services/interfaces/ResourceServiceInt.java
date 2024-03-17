package com.example.demo.services.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Resource;

@RequestMapping("/resource")
public interface ResourceServiceInt {

	@PostMapping("/")
	public ResponseEntity<Resource> createResource(@RequestBody Resource resource);
}
