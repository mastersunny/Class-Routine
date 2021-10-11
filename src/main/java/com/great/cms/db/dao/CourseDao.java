package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.Department;

public interface CourseDao extends GenericDao<Course, Integer> {

	public Integer getCourseIdByCourseCode(String courseCode);
	public Course getCourseByCode(String courseCode);
	public List<Course> getCourseByAcceptingDept(String deptCode);
	public List<Course> getCourses(int session, Department deptId);

	
}
