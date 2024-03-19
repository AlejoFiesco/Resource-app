package com.example.demo.database.factory;

import com.example.demo.model.Classroom;
import com.example.demo.model.Resource;

public enum Collections {
	RESOURCES("resources", Resource.class),
	CLASSROOMS("classrooms", Classroom.class);

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
