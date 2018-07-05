package com.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.entity.Exam;
import com.entity.Task;
import com.entity.User;

@Repository("TaskDao")
public class TaskDao extends GenericDao<Task>{
		//所有任务
		public List<Task> allTask(){
			String jpql = "SELECT t FROM Task t WHERE t.user=null";
			Query query = getEntityManager().createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<Task> tasks = query.getResultList();
			return tasks;
		}
		//查老师个人任务信息
		public List<Task> myTask(HttpSession session) {
			User user = (User) session.getAttribute("user");
			int id = user.getId();
			String jpql = "SELECT t FROM Task t WHERE t.user.id=:id";
			Query query = getEntityManager().createQuery(jpql);
			query.setParameter("id", id);
			@SuppressWarnings("unchecked")
			List<Task> tasks = query.getResultList();
			return tasks;
		}
		//某个任务的信息
		public Task find(int id) {
			String jpql = "FROM Task t WHERE t.id = :id";
			Query query = getEntityManager().createQuery(jpql);
			query.setParameter("id", id);
			Task task = null;
			try {
				task = (Task)query.getSingleResult();
			}catch (NoResultException e) {
				// TODO: handle exception
			}
			return task;
		}
		//添加任务
		public void addTask(Task task) {
			persist(task);
		}
		//删除任务
		public void deleteTask(Task task) {
			getEntityManager().remove(getEntityManager().merge(task));
		}
}
