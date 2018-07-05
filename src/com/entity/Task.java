package com.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Lob  
	@Column(columnDefinition = "TEXT",nullable = false)  
	private String content;
	@Column(nullable = false)
	private String kind;
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date finishTime;
	@Column(nullable = false)
	private Enum<stateType> state;
	public enum stateType{
		OVERTIME_UNDO,OVERTIME_DO,UNFINISHED,FINISHED
	}
	@ManyToOne
	private User user;
	@OneToMany(mappedBy = "task")
	private Set<Reply> replies;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getContent() {
		return content;
	}
	public Date getStartTime() {
		return startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public Enum<stateType> getState() {
		return state;
	}
	public User getUser() {
		return user;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public void setState(Enum<stateType> state) {
		this.state = state;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Reply> getReplies() {
		return replies;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
}
