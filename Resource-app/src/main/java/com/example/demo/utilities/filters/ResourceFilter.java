package com.example.demo.utilities.filters;

import java.util.List;

public class ResourceFilter {

	private List<String> resourcesId;

	public ResourceFilter(List<String> resourcesId) {
		this.resourcesId = resourcesId;
	}

	public List<String> getResourcesId() {
		return resourcesId;
	}

	public void setResourcesId(List<String> resourcesId) {
		this.resourcesId = resourcesId;
	}
	
	
}
