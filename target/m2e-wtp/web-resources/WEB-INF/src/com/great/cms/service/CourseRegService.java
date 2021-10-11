package com.great.cms.service;

import java.util.List;

import com.great.cms.db.entity.CourseReg;

public interface CourseRegService {
	
	public List<CourseReg> getStudentRegistration(int id);
	
	//public List<String> getCountryList();
	
}
