package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.ant.FindLeaksTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TaskDao;
import com.entity.Task;

@Service("TaskService")
@Transactional
public class TaskService {
	@Autowired
	private TaskDao taskDao;
	
	public List<Task> allTask(){
		return taskDao.allTask();
	}
	
	public List<Task> myTask(HttpSession session){
		return taskDao.myTask(session);
	}
	
	public Task find(int id) {
		return taskDao.find(id);
	}
	
	public void merge(Task task) {
		taskDao.merge(task);
	}
	
	public void addTask(Task task) {
		taskDao.addTask(task);
	}
	
	public void deleteTask(Task task) {
		taskDao.deleteTask(task);
	}
}
