package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.entity.Exam;
import com.entity.User;

@Repository("ExamDao")
public class ExamDao extends GenericDao<Exam> {
	//查老师个人监考信息
	public Set<Exam> myExam(HttpSession session) {
		User user = (User) session.getAttribute("user");
		Set<Exam> exams = user.getExams();
		return exams;
	}
	//所有考试信息
	public List<Exam> allExam() {
		String jpql = "SELECT e FROM Exam e ";
		Query query = getEntityManager().createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Exam> exams = query.getResultList();
		return exams;
	}
	//某条考试信息
	public Exam find(int id) {
		String jpql = "FROM Exam e WHERE e.id = :id";
		Query query = getEntityManager().createQuery(jpql);
		query.setParameter("id", id);
		Exam exam = null;
		try {
			exam = (Exam)query.getSingleResult();
		}catch (NoResultException e) {
			// TODO: handle exception
		}
		return exam;
	}
	//添加考试信息
	public void addExam(Exam exam) {
		persist(exam);
	}
	//修改考试信息
	public void changerExamInfo(Exam exam) {
		merge(exam);
	}
	public void delete(Exam exam) {
		getEntityManager().remove(getEntityManager().merge(exam));
	}
	//分配老师
	public void chooseTeacher(Exam exam) {
		merge(exam);
	}
	//考试状态改变
	public void changeExamState(Exam exam) {
		merge(exam);
	}
	//更换分配老师
	public void changeTeacher(Exam exam) {
		merge(exam);
	}
}
