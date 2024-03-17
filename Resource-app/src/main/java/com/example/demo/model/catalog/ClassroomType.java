package com.example.demo.model.catalog;

import java.util.List;

import com.example.demo.model.Resource;

public class ClassroomType {
	private String id;
	private String name;
	private List<Resource> avalaibleResourceList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Resource> getResourceList() {
		return avalaibleResourceList;
	}
	public void setResourceList(List<Resource> resourceList) {
		this.avalaibleResourceList = resourceList;
	}
	
}
