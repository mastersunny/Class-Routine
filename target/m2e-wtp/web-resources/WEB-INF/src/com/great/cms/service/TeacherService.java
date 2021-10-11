package com.great.cms.service;

import java.util.List;

import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Teacher;
import com.great.cms.db.entity.Teaches;

public interface TeacherService {

	public String getTeacherCodeById(Long instructorId);
	public Teacher getTeacherById(Long instructorId);
	public List<Teacher> getListByDept(Department dept);
	public void deleteById(Long Id); 
	public void addNew(Teacher teacher);
	public void update(Teacher teacher);
	public List<Teaches> getTeaches(Teacher instructorId);
	public Teacher getTeacher(String username);
	public List<Teaches> getTeaches(Teacher teacher, int session,Department deptId);
	public Teaches getTeachesById(Integer teachesId);
	public List<Teaches> getTeaches(int session, Department deptId);
}
