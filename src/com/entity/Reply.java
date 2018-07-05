package com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date finishTime;
	@ManyToOne
	private Task task;
	@ManyToOne 
	private User user;
	private String detail;
	public int getId() {
		return id;
	}	
	public Date getFinishTime() {
		return finishTime;
	}
	public String getDetail() {
		return detail;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Task getTask() {
		return task;
	}
	public User getUser() {
		return user;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
