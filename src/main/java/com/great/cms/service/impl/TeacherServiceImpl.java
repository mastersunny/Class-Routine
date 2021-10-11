package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.TeacherDao;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Teacher;
import com.great.cms.db.entity.Teaches;
import com.great.cms.service.TeacherService;

@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherDao teacherDao;

	@Override
	public String getTeacherCodeById(Long instructorId) {

		Teacher teacher = this.teacherDao.findById(instructorId);

		return teacher.getEmployeeCode();
	}

	@Override
	public List<Teacher> getListByDept(Department dept) {

		return teacherDao.getListByDept(dept);
	}

	@Override
	public void deleteById(Long Id) {
		
		this.teacherDao.deleteById(Id);

	}

	@Override
	public void addNew(Teacher teacher) {
		// TODO Auto-generated method stub
		this.teacherDao.save(teacher);

	}

	@Override
	public void update(Teacher teacher) {
		// TODO Auto-generated method stub

		this.teacherDao.update(teacher);
	}

	@Override
	public Teacher getTeacherById(Long instructorId) {
		// TODO Auto-generated method stub

		Teacher teacher = teacherDao.findById(Teacher.class, instructorId);

		return teacher;
	}

	@Override
	public List<Teaches> getTeaches(Teacher instructorId) {

		List<Teaches> teaches = teacherDao.getTeaches(instructorId);

		return teaches;
	}

	@Override
	public Teacher getTeacher(String username) {

		Teacher teacher = teacherDao.getTeacherByCode(username);
		return teacher;
	}

	@Override
	public List<Teaches> getTeaches(Teacher teacher, int session, Department deptId) {

		List<Teaches> teaches = teacherDao.getTeaches(teacher, session, deptId);

		return teaches;
	}

	@Override
	public Teaches getTeachesById(Integer teachesId) {

		return teacherDao.getTeaches(teachesId);

	}

	@Override
	public List<Teaches> getTeaches(int session, Department deptId) {

		return teacherDao.getTeaches(session, deptId);
	}

}
