package com.example.demo.business.interfaces;

import java.util.List;

import com.example.demo.model.Resource;

public interface ResourceBusinessInt {
	public Resource createResource(Resource resource) throws Exception;
	
	public List<Resource> getResourceList() throws Exception;
	
	public Resource getResourceById(String id) throws Exception;
}
