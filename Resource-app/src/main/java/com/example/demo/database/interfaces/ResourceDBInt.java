package com.example.demo.database.interfaces;

import java.util.List;

import com.example.demo.model.Resource;
import com.example.demo.utilities.filters.ResourceFilter;

public interface ResourceDBInt {

	public Resource createResource(Resource resource) throws Exception;
	List<Resource> getResourceList(ResourceFilter filter) throws Exception;
}
