package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Teacher;
import com.great.cms.db.entity.Teaches;

public interface TeacherDao extends GenericDao<Teacher, Long> {

	public List<Teacher> getListByDept(Department dept);

	public Teacher getTeacherByCode(String username);

	public List<Teaches> getTeaches(Teacher instructorId);

	public List<Teaches> getTeaches(Teacher teacher, int session, Department deptId);

	public Teaches getTeaches(Integer teachesId);

	public List<Teaches> getTeaches(int session, Department deptId);
}
