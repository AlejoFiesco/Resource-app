package com.example.demo.utilities.filters;


public class ReserveFilter extends Filter{
	private String classroomId;
	private String resourceId;
	private String reservedById;
	private String startDate;
	private String endDate;
	
	
	
	public ReserveFilter(String classroomId, String resourceId, String reservedById, String startDate, String endDate) {
		super();
		this.classroomId = classroomId;
		this.resourceId = resourceId;
		this.reservedById = reservedById;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public String getClassroomId() {
		return classroomId;
	}
	public void setClassroomId(String classroomId) {
		this.classroomId = classroomId;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getReservedById() {
		return reservedById;
	}
	public void setReservedById(String reservedById) {
		this.reservedById = reservedById;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
