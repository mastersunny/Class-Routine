package com.great.cms.db.dao;

import com.great.cms.db.entity.User;


public interface UserDao extends GenericDao<User, Integer> {

	public User getIdByUseRegAndPassword(String userReg , String password);

	public User getUser(String username);


	

}
