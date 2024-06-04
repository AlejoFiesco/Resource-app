package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.implementation.ResourceBusinessImp;
import com.example.demo.config.AuthenticatorAnnotation;
import com.example.demo.model.Resource;
import com.example.demo.model.catalog.ResourceType;
import com.example.demo.services.interfaces.ResourceServiceInt;
import com.example.demo.utilities.responses.CustomResponse;

@RestController
public class ResourceServiceImpl implements ResourceServiceInt{

	@Autowired
	ResourceBusinessImp resourceBusiness;
	
	@Override
	@AuthenticatorAnnotation
	public ResponseEntity<Resource> createResource(Resource resource) {
		Resource createdResource = null;
		try {
			createdResource = resourceBusiness.createResource(resource);
		}catch(Exception e) {
			System.out.println(e);
		}
		return CustomResponse.buildResponse(createdResource);
	}

	@Override
	public ResponseEntity<List<Resource>> getResources() {
		List<Resource> resourceList = null;
		try {
			resourceList = resourceBusiness.getResourceList();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return CustomResponse.buildResponse(resourceList);
	}

	@Override
	public ResponseEntity<Resource> getResourceById(String id) {
		Resource returnedResource = null;
		
		if(id != null) {
			try {
				returnedResource = resourceBusiness.getResourceById(id);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		return CustomResponse.buildResponse(returnedResource);
	}
	
	public ResponseEntity<List<ResourceType>> getResourceTypeList(){
		try{
			return CustomResponse.buildResponse(resourceBusiness.getResourceTypeList()); 
		}catch(Exception e) {
			return CustomResponse.buildResponse(e.getLocalizedMessage());
		}
	}
	
	public ResponseEntity<ResourceType> createResourceType(ResourceType resourceType){
		try{
			return CustomResponse.buildResponse(resourceBusiness.createResourceType(resourceType)); 
		}catch(Exception e) {
			return CustomResponse.buildResponse(e.getLocalizedMessage());
		}
	}

}
