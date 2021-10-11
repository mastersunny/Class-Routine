package com.great.cms.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.DesignationDao;
import com.great.cms.db.entity.Designation;

@Repository("DesignationDao")
public class DesignationDaoImpl extends GenericDaoImpl<Designation, Integer> implements DesignationDao {

		public DesignationDaoImpl()
		{
			super(Designation.class);
		}
}
