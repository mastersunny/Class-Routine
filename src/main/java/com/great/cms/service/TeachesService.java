package com.great.cms.service;

import java.util.List;

import com.great.cms.controller.bean.CourseAndTeacher;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.Teacher;
import com.great.cms.db.entity.Teaches;

public interface TeachesService {

	public Integer getCourseIdByTeachesId(Integer teachesId);

	public Long getTeacherIdByTeachesId(Integer teachesId);

	public List<Teaches> getTeaches(int session, String deptCode);

	Teaches getTeaches(Course courseId, Teacher instructorId);

	public void addTeaches(Teaches teaches);

}
