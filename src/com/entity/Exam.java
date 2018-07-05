package com.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String examName;
	@Column(nullable = false)
	private int studentNumber;
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	private Enum<stateType> state;
	public enum stateType{
		UNALLOCATION,ALLOCATION,FINISHED
	}
	private String address;
	@ManyToMany(fetch=FetchType.EAGER)  
	@JoinTable(name ="USER_EXAM",
	joinColumns = @JoinColumn(name="EXAM_ID",referencedColumnName="ID"),
	inverseJoinColumns = @JoinColumn(name="USER_ID",referencedColumnName="ID"))
	private Set<User> users;
	
	public int getId() {
		return id;
	}
	public String getExamName() {
		return examName;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
	public Date getStartTime() {
		return startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public Enum<stateType> getState() {
		return state;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public void setState(Enum<stateType> state) {
		this.state = state;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
