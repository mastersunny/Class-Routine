package com.great.cms.service;

import java.util.List;

import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.Department;

public interface CourseService {

	public List<Course> getCourseList();

	public String getCourseCodeById(Integer courseId);

	public void addCourse(Course course);

	public List<Course> getCourseByAcceptingDept(String deptCode);

	public boolean update(Course course);

	public List<Course> getCourses(int session, Department deptId);

	public Course getCourse(int courseId);

}
