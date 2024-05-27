package com.example.demo.business.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.interfaces.ResourceBusinessInt;
import com.example.demo.database.factory.Factory;
import com.example.demo.database.implementation.ResourceDBImpl;
import com.example.demo.model.Resource;

@Service
public class ResourceBusinessImp implements ResourceBusinessInt {
	
	@Autowired
	ResourceDBImpl resourceDb;
	
	@Autowired
	Factory factory;
	
	public Resource createResource(Resource resource) throws Exception {
		Resource createdResource = null;
		if(resource != null) {
			try {				
				createdResource = (Resource) factory.create(resource, null);
			}catch(Exception e) {
				throw e;
			}
		}
		return createdResource;
	}

	public List<Resource> getResourceList() throws Exception {
		List<Resource> resourceList;
		
		try {
			resourceList = factory.getList(Resource.class, null);
		}catch(Exception e) {
			throw e;
		}
		return resourceList;
	}

	@Override
	public Resource getResourceById(String id) throws Exception{
		Resource resource = null;
		
		try {
			resource = factory.getById(Resource.class, id);
		}catch(Exception e) {
			throw e;
		}
		
		return resource;
	}
}
