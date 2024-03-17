package com.example.demo.model;

import com.example.demo.model.catalog.ClassroomType;

public class Classroom {
	private int capacity;
	private int movableChairs;
	private int staticChairs;
	private int movableTables;
	private int staticTables;
	private ClassroomType type;
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getMovableChairs() {
		return movableChairs;
	}
	public void setMovableChairs(int movableChairs) {
		this.movableChairs = movableChairs;
	}
	public int getStaticChairs() {
		return staticChairs;
	}
	public void setStaticChairs(int staticChairs) {
		this.staticChairs = staticChairs;
	}
	public int getMovableTables() {
		return movableTables;
	}
	public void setMovableTables(int movableTables) {
		this.movableTables = movableTables;
	}
	public int getStaticTables() {
		return staticTables;
	}
	public void setStaticTables(int staticTables) {
		this.staticTables = staticTables;
	}
	public ClassroomType getType() {
		return type;
	}
	public void setType(ClassroomType type) {
		this.type = type;
	}
}
