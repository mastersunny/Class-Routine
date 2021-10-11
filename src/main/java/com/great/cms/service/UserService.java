package com.great.cms.service;

import com.great.cms.db.entity.User;

public interface UserService {
	
	public void signUp(String userReg , String passward , String role);
	public String generatePassword();
	public User getIdByUserRegAndPassword(String userReg , String password);
	public User getUser(String username);
	public boolean createUser(User user);
	
	
}
