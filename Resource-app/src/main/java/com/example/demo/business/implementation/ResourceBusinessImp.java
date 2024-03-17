package com.example.demo.business.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.interfaces.ResourceBusinessInt;
import com.example.demo.database.implementation.ResourceDBImpl;
import com.example.demo.model.Resource;

@Service
public class ResourceBusinessImp implements ResourceBusinessInt {
	
	@Autowired
	ResourceDBImpl resourceDb;
	
	public Resource createResource(Resource resource) throws Exception {
		Resource createdResource = null;
		if(resource != null) {
			try {				
				createdResource = resourceDb.createResource(resource);
			}catch(Exception e) {
				throw e;
			}
		}
		return createdResource;
	}
}
