package com.example.demo.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Resource;

@RequestMapping("/resource")
public interface ResourceServiceInt {

	@PostMapping("/")
	public ResponseEntity<Resource> createResource(@RequestBody Resource resource);
	
	@GetMapping("/")
	public ResponseEntity<List<Resource>> getResources();
	
	@GetMapping("/{resourceId}")
	public ResponseEntity<Resource> getResourceById(@PathVariable(value="resourceId") String id);

}
