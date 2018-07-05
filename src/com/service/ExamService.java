package com.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ExamDao;
import com.entity.Exam;
import com.entity.Exam.stateType;

@Service("ExamService")
@Transactional
public class ExamService {
	@Autowired
	private ExamDao examDao;
	
	public Set<Exam> myExam(HttpSession session){
		return examDao.myExam(session);
	}
	
	public List<Exam> allExam(){
		return examDao.allExam();
	}
	
	public Exam find(int id) {
		return examDao.find(id);
	}
	
	public void addExam(Exam exam) {
		examDao.addExam(exam);
	}
	
	public void delete(Exam exam) {
		examDao.delete(exam);
	}
	
	public List<Exam> list(){
		return examDao.list();
	}

	//修改考试信息
	public void changerExamInfo(Exam exam) {
		examDao.changerExamInfo(exam);
	}
	//分配老师
	public void chooseTeacher(Exam exam) {
		//查看老师当前考试信息状况
		examDao.chooseTeacher(exam);
	}
	//考试状态改变
	public void changeExamState(Exam exam) {
		Date date = new Date();
		if(exam.getUsers() != null) {
			if(exam.getEndTime().before(date))
				exam.setState(stateType.ALLOCATION);
			else {
				exam.setState(stateType.FINISHED);
			}
		}
		else
			exam.setState(stateType.UNALLOCATION);
		examDao.changeExamState(exam);
	}
	//更换分配老师
	public void changeTeacher(Exam exam) {
		examDao.changeTeacher(exam);
	}
}

