package com.example.demo.model;

import java.util.List;

import com.example.demo.model.catalog.ResourceType;
import com.example.demo.model.subclasses.TimeRange;

public class Resource {
	private String id;
	private String name;
	private String description;
	private List<String> avalaibleDays;
	private List<TimeRange> disponibility;
	private ResourceType resourceType;
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getAvalaibleDays() {
		return avalaibleDays;
	}
	public void setAvalaibleDays(List<String> avalibleDays) {
		this.avalaibleDays = avalibleDays;
	}
	public List<TimeRange> getDisponibility() {
		return disponibility;
	}
	public void setDisponibility(List<TimeRange> disponibility) {
		this.disponibility = disponibility;
	}
	public ResourceType getResourceType() {
		return resourceType;
	}
	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}	
}
