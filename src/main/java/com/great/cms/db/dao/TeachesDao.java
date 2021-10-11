package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.controller.bean.CourseAndTeacher;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.Teacher;
import com.great.cms.db.entity.Teaches;

public interface TeachesDao extends GenericDao<Teaches, Integer> {
	
	public Integer getCourseIdByTeachesId(Integer teachesId);
	public Long getTeacherIdByTeachesId(Integer teachesId);
	public List<Teaches> getTeaches(int session, String deptCode);
	Teaches getTeaches(Course courseId, Teacher instructorId);
	

}
