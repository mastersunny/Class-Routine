package com.great.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.AuthorityDao;
import com.great.cms.db.entity.Authorities;
import com.great.cms.service.AuthorityService;

@Service("AuthorityService")
public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	AuthorityDao authorityDao;
	
	@Override
	public boolean createAuthority(Authorities authorities) {
		
		try{
			authorityDao.save(authorities);
			return true;
		}catch(RuntimeException r){
			System.out.println(r.getMessage());
		
		}
		return false;
	}
	
	

}
