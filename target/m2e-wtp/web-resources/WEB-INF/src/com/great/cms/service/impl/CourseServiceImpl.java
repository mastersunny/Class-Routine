package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.CourseDao;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.Department;
import com.great.cms.service.CourseService;

@Service("CourseService")
public class CourseServiceImpl implements CourseService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	CourseDao courseDao;

	@Override
	public List<Course> getCourseList() {
		List<Course> courseList = null;
		courseList = this.courseDao.findAll();
		return courseList;
	}

	@Override
	public String getCourseCodeById(Integer courseId) {
		// TODO Auto-generated method stub
		Course course = this.courseDao.findById(courseId);
		return course.getCourseCode();
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.save(course);
	}

	@Override
	public List<Course> getCourseByAcceptingDept(String deptCode) {
		// TODO Auto-generated method stub

		return courseDao.getCourseByAcceptingDept(deptCode);
	}

	@Override
	public boolean update(Course course) {

		try {
			courseDao.update(course);
			return true;

		} catch (RuntimeException r) {
			System.out.println(r.getMessage());
		}

		return false;
	}

	@Override
	public List<Course> getCourses(int session, Department deptId) {

		return courseDao.getCourses(session, deptId);
	}

	@Override
	public Course getCourse(int courseId) {

		return courseDao.findById(courseId);
	}

}
