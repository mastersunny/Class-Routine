package com.great.cms.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.GeneralTypeDao;
import com.great.cms.db.entity.GeneralType;

@Repository("GeneralTypeDao")
public class GeneralTypeDaoImpl extends GenericDaoImpl<GeneralType, Integer> implements GeneralTypeDao {

	public GeneralTypeDaoImpl()
	{
		super(GeneralType.class);
	}
}
