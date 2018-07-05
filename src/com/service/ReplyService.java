package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ReplyDao;
import com.entity.Reply;
import com.entity.Task;
import com.entity.User;

@Service("ReplyService")
@Transactional
public class ReplyService {
	@Autowired
	private ReplyDao replyDao;
	
	//某一个回复类通知在管理员界面看到的全部回复内容
	public List<Reply> allReply(int id){
		return replyDao.allReply(id);
	}
	//某个老师回复通知
	public void addReply(User user,Task task,String detail) {
		replyDao.addReply(user, task, detail);
	}
	//查看老师的全部回复通知
	public List<Reply> checkAllReply(User user){
		return replyDao.checkAllReply(user);
	}
	//查看某老师的某回复通知
	public Reply checkReply(User user,Task task) {
		return replyDao.checkReply(user, task);
	}
}
