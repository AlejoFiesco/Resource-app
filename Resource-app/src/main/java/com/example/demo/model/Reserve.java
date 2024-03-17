package com.example.demo.model;

import java.util.Date;
import java.util.List;

import com.example.demo.model.subclasses.Score;
import com.example.demo.model.subclasses.TimeRange;

public class Reserve {
	private Classroom classroom;
	private List<Resource> resourceList;
	private Date reservedDate;
	private TimeRange timeRange;
	private User reservedBy;
	private Date createdDate;
	private Date devolutionDate;
	private boolean active;
	private Score score;
	
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public List<Resource> getResourceList() {
		return resourceList;
	}
	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}
	public Date getReservedDate() {
		return reservedDate;
	}
	public void setReservedDate(Date reservedDate) {
		this.reservedDate = reservedDate;
	}
	public TimeRange getTimeRange() {
		return timeRange;
	}
	public void setTimeRange(TimeRange timeRange) {
		this.timeRange = timeRange;
	}
	public User getReservedBy() {
		return reservedBy;
	}
	public void setReservedBy(User reservedBy) {
		this.reservedBy = reservedBy;
	}
	public Date getReserverWhen() {
		return createdDate;
	}
	public void setReserverWhen(Date reserverWhen) {
		this.createdDate = reserverWhen;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}	
}
