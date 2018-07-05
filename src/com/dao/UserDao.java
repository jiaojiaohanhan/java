package com.dao;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.entity.User;
import com.entity.User.identityType;

@Repository("UserDao")
public class UserDao extends GenericDao<User> {
	//所有用户
	public List<User> list(){
		String jpql = "SELECT u FROM User u";
		Query query = getEntityManager().createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		return users;
	}
	//登陆时查找用户
	public User find(String userName, String password) {
		String jpql = "FROM User u WHERE u.userName = :userName AND u.password = :password";
		Query query = getEntityManager().createQuery(jpql);
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		User user = null;
		try {
			user = (User)query.getSingleResult();
		}catch (NoResultException e) {
			// TODO: handle exception
		}
		return user;
	}
	//修改密码
	public void updatePassword(String userName,String password) {
		String jpql = "UPDATE User u SET u.password = :password WHERE u.userName = :userName";
		Query query = getEntityManager().createQuery(jpql);
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		query.executeUpdate();
	}
	//教师修改个人信息
	public void updateUserInfo(User user) {
		merge(user);
	}
	//管理员修改用户信息和个人信息
	public void adminUpdateInfo(User user) {
		merge(user);
	}
	
	//管理员添加用户
	public void addUser(User user) {
		persist(user);
	}
	//管理员删除管理员
	public void deleteAdmin(User user) {
		user.setIdentity(identityType.USER);
		merge(user);
	}
	//管理员添加管理员
	public void addAdmin(User user) {
		user.setIdentity(identityType.ADMIN);
		merge(user);
	}
	//查询全部管理员
	@SuppressWarnings("unchecked")
	public List<User> allAdmin(){
		String jpql = "FROM User u WHERE u.identity = :identity";
		Query query = getEntityManager().createQuery(jpql);
		query.setParameter("identity", 1);
		List<User> users = query.getResultList();
		return users;
	}
	//查询当前老师为监考的考试数量
	//删除用户
	public void delete(User user) {
		getEntityManager().remove(getEntityManager().merge(user));
	}
}
