package com.manager;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.entity.Exam;
import com.entity.Task;
import com.entity.Exam.stateType;
import com.entity.User;
import com.entity.User.identityType;
import com.entity.User.titleType;


public class Manager {
	
	private static Logger logger = LogManager.getLogger(Manager.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// JavaSE环境下，EntityManagerFactory & EntityManager 必须手动关闭释放资源
		EntityManagerFactory emFactory = null;
		EntityManager em = null;
		EntityTransaction transaction = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("jpa");
			em = emFactory.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();

//			 先存在user对象
//			User user = new User();
//			user.setUserName("li");
//			user.setPassword("1234");
//			user.setDetail("1");
//			user.setName("jiao");
//			user.setTitle(titleType.aPROFESSOR);
//			user.setIdentity(identityType.ADMIN);
//			em.persist(user);
//
//			User user1 = new User();
//			user1.setUserName("wang");
//			user1.setPassword("1234");
//			user1.setDetail("2");
//			user1.setName("jiao");
//			user1.setTitle(titleType.PROFESSOR);
//			user1.setIdentity(identityType.USER);
//			em.persist(user1);
			
//			exam对象
//			Exam exam = new Exam();
//			exam.setAddress("30,40");
//			exam.setExamName("数学");
//			exam.setStartTime(null);
//			exam.setEndTime(null);
//			exam.setState(stateType.UNALLOCATION);
//			exam.setStudentNumber(50);
//			em.persist(exam);
//			
//			Exam exam1 = new Exam();
//			exam1.setAddress("20,30");
//			exam1.setExamName("编程");
//			exam1.setStartTime(null);
//			exam1.setEndTime(null);
//			exam1.setState(stateType.UNALLOCATION);
//			exam1.setStudentNumber(30);
//			em.persist(exam1);
			
//			task对象
//			Task task = new Task();
//			task.setName("作业一");
//			task.setContent("aaaa");
//			task.setState(com.entity.Task.stateType.OVERTIME_UNDO);
//			em.persist(task);
//			
//			Task task1 = new Task();
//			task1.setName("作业二");
//			task1.setContent("bbbb");
//			task1.setState(com.entity.Task.stateType.OVERTIME_UNDO);
//			em.persist(task1);
//			
//			Task task2 = new Task();
//			task2.setName("作业三");
//			task2.setContent("cccc");
//			task2.setState(com.entity.Task.stateType.OVERTIME_UNDO);
//			em.persist(task2);
			
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			// 打印异常栈详细信息
			logger.error("持久化异常！", e);
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			// 关闭EntityManager
			if (em != null && em.isOpen()) {
				em.close();
			}
			// 关闭EntityManagerFactory
			if (emFactory != null && emFactory.isOpen()) {
				emFactory.close();
			}
		}
	}
}
