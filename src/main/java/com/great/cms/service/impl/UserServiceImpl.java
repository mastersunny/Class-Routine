package com.great.cms.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.UserDao;
import com.great.cms.db.entity.User;
import com.great.cms.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	UserDao userDao;

	@Override
	public void signUp(String userReg, String passward, String role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String generatePassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getIdByUserRegAndPassword(String userReg, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String username) {
		
		return userDao.getUser(username);
	}

	@Override
	public boolean createUser(User user) {
		
		try{
			userDao.save(user);
			return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return false;
	}

	

	

	

}
