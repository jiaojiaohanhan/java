package com.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.entity.Reply;
import com.entity.Task;
import com.entity.User;

@Repository("ReplyDao")
public class ReplyDao extends GenericDao<Reply>{
	//某一个回复类通知在管理员界面看到的全部回复内容
	@SuppressWarnings("unchecked")
	public List<Reply> allReply(int id) {
		String jpql = "FROM Reply r WHERE r.task.id = :id";
		Query query = getEntityManager().createQuery(jpql);
		query.setParameter("id", id);
		List<Reply> replies = query.getResultList();
		return replies;
	}
	//某个老师回复通知
	public void addReply(User user,Task task,String detail) {
		Reply reply = new Reply();
		reply.setTask(task);
		reply.setUser(user);
		reply.setDetail(detail);
		persist(reply);
	}
	//查看老师的全部回复通知
	@SuppressWarnings("unchecked")
	public List<Reply> checkAllReply(User user) {
		String jpql = "FROM Reply r WHERE r.user.id = :id";
		Query query = getEntityManager().createQuery(jpql);
		query.setParameter("id", user.getId());
		List<Reply> replies = query.getResultList();
		return replies;
	}
	//查看某老师的某回复通知
	public Reply checkReply(User user,Task task) {
		String jpql = "FROM Reply r WHERE r.user.id = :user_id AND r.task.id = :task_id";
		Query query = getEntityManager().createQuery(jpql);
		query.setParameter("user_id", user.getId());
		query.setParameter("task_id", task.getId());
		Reply reply = null;
		try {
			reply = (Reply)query.getSingleResult();
		}catch(NoResultException e) {
			// TODO: handle exception
		}
		return reply;
	}
}
