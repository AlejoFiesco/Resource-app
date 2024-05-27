package com.example.demo.utilities.reserve;

public enum RangeAttributes {
	
	START_DATE("to"),
	END_DATE("from");

	private String name;
	
	RangeAttributes(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
