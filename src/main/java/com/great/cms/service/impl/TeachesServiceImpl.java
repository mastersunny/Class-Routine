package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.controller.bean.CourseAndTeacher;
import com.great.cms.db.dao.TeachesDao;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.Teacher;
import com.great.cms.db.entity.Teaches;
import com.great.cms.service.TeachesService;

@Service("TeachesService")
public class TeachesServiceImpl implements TeachesService, Serializable {

	@Autowired
	TeachesDao teachesDao;

	@Override
	public Integer getCourseIdByTeachesId(Integer teachesId) {
		// TODO Auto-generated method stub
		return (teachesDao.getCourseIdByTeachesId(teachesId));
	}

	@Override
	public Long getTeacherIdByTeachesId(Integer teachesId) {
		// TODO Auto-generated method stub
		return (teachesDao.getTeacherIdByTeachesId(teachesId));
	}

	@Override
	public List<Teaches> getTeaches(int session, String deptCode) {

		List<Teaches> teaches = teachesDao.getTeaches(session, deptCode);
		return teaches;
	}

	@Override
	public Teaches getTeaches(Course courseId, Teacher instructorId) {

		return teachesDao.getTeaches(courseId, instructorId);
	}

	@Override
	public void addTeaches(Teaches teaches) {

		teachesDao.update(teaches);

	}

}
