package com.example.demo.database.factory;

import com.example.demo.model.Aisle;
import com.example.demo.model.Classroom;
import com.example.demo.model.Reserve;
import com.example.demo.model.Resource;
import com.example.demo.model.User;
import com.example.demo.model.catalog.ResourceType;
import com.example.demo.model.catalog.UserType;

public enum Collections {
	RESOURCES("resources", Resource.class),
	CLASSROOMS("classrooms", Classroom.class),
	AISLES("aisles", Aisle.class),
	RESERVES("reserves", Reserve.class),
	USERS("users", User.class),
	USER_TYPES("userType", UserType.class),
	RESOURCE_TYPES("resourceType", ResourceType.class);

	private final String collectionName;
	private final Class<?> class1;
	
	Collections(String string, Class<?> class1) {
		this.collectionName = string;
		this.class1 = class1;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public Class<?> getClass1() {
		return class1;
	}
	
	

}
