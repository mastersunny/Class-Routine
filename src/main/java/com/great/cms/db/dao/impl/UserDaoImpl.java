package com.great.cms.db.dao.impl;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.db.dao.UserDao;
import com.great.cms.db.entity.Authorities;
import com.great.cms.db.entity.User;

@Repository("UserDao")
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements
		UserDao {

	public UserDaoImpl() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	User user;
//	@Autowired
//	UserDao userDao;
	
	
	@Override
	@Transactional
	public User getIdByUseRegAndPassword(String userReg , String password) {

		
			Query query = this.em
					.createQuery("from User u where u.userReg = :userReg and u.password = :password");

			query.setParameter("userReg", userReg);
			query.setParameter("password", password);
			
			User userId = (User) query.getResultList().get(0);
			
			return userId;
		
		
		
	}


	@Override
	@Transactional
	public User getUser(String username) {
		
		Query query = this.em.createNamedQuery("User.findByUsername");
		query.setParameter("username", username);
		
		return (User) query.getResultList().get(0);
	}








	
	

}

