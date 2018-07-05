package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.entity.User;

@Service("UserService")
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public User getUser(String userName,String password) {
		return userDao.find(userName,password);
	}
	
	public User find(int id) {
		return userDao.find(id);
	}
	
	public List<User> listUser(){
		return userDao.list();
	}
	
	public void updateUserInfo(User user) {
		userDao.updateUserInfo(user);
	}
	
	public void adminUpdateInfo(User user) {
		userDao.adminUpdateInfo(user);
	}
	
	public void updatePassword(String userName, String password) {
		userDao.updatePassword(userName, password);
	}
	
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public void delete(User user) {
		userDao.delete(user);
	}
	
	public void deleteAdmin(User user) {
		userDao.deleteAdmin(user);
	}
	
	public void addAdmin(User user) {
		userDao.addAdmin(user);
	}
	
	public List<User> listAllAdmin(){
		return userDao.allAdmin();
	}
	
	public static String convertMD5(String inStr){  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
    }
}
