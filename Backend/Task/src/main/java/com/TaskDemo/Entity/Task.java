package com.TaskDemo.Entity;

import java.util.Date;

public class Task {

	private Long id;
	private String taskName;
	private String taskDescription;
	private Short status;
	private Date dateSubmit;
	private Short priority;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Date getDateSubmit() {
		return dateSubmit;
	}
	public void setDateSubmit(Date dateSubmit) {
		this.dateSubmit = dateSubmit;
	}
	
	public Short getPriority() {
		return priority;
	}
	public void setPriority(Short priority) {
		this.priority = priority;
	}
	
	public Task() {
	}
	public Task(Long id, String taskName, String taskDescription, Short status, Date dateSubmit, Short priority) {
		this.id = id;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.status = status;
		this.dateSubmit = dateSubmit;
		this.priority = priority;
	}
	
	
	
}
