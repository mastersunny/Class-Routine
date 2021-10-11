package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.CourseReg;

public interface CourseRegDao extends GenericDao<CourseReg, Integer> {

	List<CourseReg> getRegistrationByIdStudent(int id);

}
