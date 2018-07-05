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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String userName;   //用户名
	@Column(nullable = false)
	private String password;
	private String name;       //真实姓名
	private Enum<titleType> title;
	public enum titleType{
		LECTURER,aPROFESSOR,PROFESSOR
	}
	@Column(nullable = false)
	private String detail;
	private int phoneNumber;
	private Enum<identityType> identity;
	public enum identityType{
		USER,ADMIN
	}
	@ManyToMany(fetch=FetchType.EAGER)  
	@JoinTable(name ="USER_EXAM",
			joinColumns = @JoinColumn(name="USER_ID",referencedColumnName="ID"),
			inverseJoinColumns = @JoinColumn(name="EXAM_ID",referencedColumnName="ID"))
	private Set<Exam> exams;
	@Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insertTime;
	@OneToMany(mappedBy="user")
	private Set<Task> task;
	@OneToMany(mappedBy = "user")
	private Set<Reply> replies;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Set<Exam> getExams() {
		return exams;
	}
	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public Enum<titleType> getTitle() {
		return title;
	}
	public String getDetail() {
		return detail;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public Enum<identityType> getIdentity() {
		return identity;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public Set<Task> getTask() {
		return task;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTitle(Enum<titleType> title) {
		this.title = title;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setIdentity(Enum<identityType> identity) {
		this.identity = identity;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public void setTask(Set<Task> task) {
		this.task = task;
	}
	public Set<Reply> getReplies() {
		return replies;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
}
