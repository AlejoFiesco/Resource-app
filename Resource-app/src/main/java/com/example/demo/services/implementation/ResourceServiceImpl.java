package com.example.demo.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.implementation.ResourceBusinessImp;
import com.example.demo.model.Resource;
import com.example.demo.services.interfaces.ResourceServiceInt;

@RestController
public class ResourceServiceImpl implements ResourceServiceInt{

	@Autowired
	ResourceBusinessImp resourceBusiness;
	
	@Override
	public ResponseEntity<Resource> createResource(Resource resource) {
		Resource createdResource = null;
		try {
			createdResource = resourceBusiness.createResource(resource);
		}catch(Exception e) {
			ResponseEntity.internalServerError();
		}
		return ResponseEntity.ok(createdResource);
	}

}
