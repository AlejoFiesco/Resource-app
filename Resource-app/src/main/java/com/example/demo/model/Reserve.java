package com.example.demo.model;

import java.util.Date;
import java.util.List;

import com.example.demo.model.subclasses.Score;

public class Reserve {
	private String id;
	private Classroom classroom;
	private List<String> resourceIdList;
	private List<Resource> resourceList;
	private Date from;
	private Date to;
	private User reservedBy;
	private Date createdDate;
	private Date devolutionDate;
	private Score score;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	
	public List<String> getResourceIdList() {
		return resourceIdList;
	}
	public void setResourceIdList(List<String> resourceIdList) {
		this.resourceIdList = resourceIdList;
	}
	
	public List<Resource> getResourceList() {
		return resourceList;
	}
	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public User getReservedBy() {
		return reservedBy;
	}
	public void setReservedBy(User reservedBy) {
		this.reservedBy = reservedBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getDevolutionDate() {
		return devolutionDate;
	}
	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}	
}
