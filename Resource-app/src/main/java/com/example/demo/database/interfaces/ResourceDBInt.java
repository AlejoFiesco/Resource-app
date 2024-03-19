package com.example.demo.database.interfaces;

import java.util.List;

import com.example.demo.model.Resource;

public interface ResourceDBInt {

	public Resource createResource(Resource resource) throws Exception;
	public List<Resource> getResourceList() throws Exception;
}
