package com.example.demo.model;

import java.util.List;

public class Aisle {
	private List<Classroom> classroomList;
	private boolean isolable;
	private boolean amplifiedAudio;
	private boolean foodDistribute;
	private int peopleCapacity;
	public List<Classroom> getClassroomList() {
		return classroomList;
	}
	public void setClassroomList(List<Classroom> classroomList) {
		this.classroomList = classroomList;
	}
	public boolean isIsolable() {
		return isolable;
	}
	public void setIsolable(boolean isolable) {
		this.isolable = isolable;
	}
	public boolean isAmplifiedAudio() {
		return amplifiedAudio;
	}
	public void setAmplifiedAudio(boolean amplifiedAudio) {
		this.amplifiedAudio = amplifiedAudio;
	}
	public boolean isFoodDistribute() {
		return foodDistribute;
	}
	public void setFoodDistribute(boolean foodDistribute) {
		this.foodDistribute = foodDistribute;
	}
	public int getPeopleCapacity() {
		return peopleCapacity;
	}
	public void setPeopleCapacity(int peopleCapacity) {
		this.peopleCapacity = peopleCapacity;
	}
	
	
}
