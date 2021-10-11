package com.great.cms.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.AuthorityDao;
import com.great.cms.db.entity.Authorities;

@Repository("AuthorityDao")
public class AuthorityDaoImpl extends GenericDaoImpl<Authorities, Long> implements AuthorityDao{
	
	 public AuthorityDaoImpl(){
		 super(Authorities.class);
	 }
	 

}
