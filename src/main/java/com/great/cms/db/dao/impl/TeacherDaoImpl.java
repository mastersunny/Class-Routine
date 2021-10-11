package com.great.cms.db.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.db.dao.TeacherDao;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Teacher;
import com.great.cms.db.entity.Teaches;

@Repository("TeacherDao")
public class TeacherDaoImpl extends GenericDaoImpl<Teacher, Long> implements TeacherDao {

	public TeacherDaoImpl() {
		super(Teacher.class);
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Teacher> getListByDept(Department department) {

		Query query = this.em.createQuery("from Teacher t where t.deptId =:deptId and t.isAvailable = 1");
		query.setParameter("deptId", department);

		List<Teacher> teachers = query.getResultList();

		return teachers;
	}

	@Override
	public Teacher getTeacherByCode(String username) {

		Query query = this.em.createQuery("from Teacher t where t.employeeCode = :employeeCode");
		query.setParameter("employeeCode", username);

		@SuppressWarnings("unchecked")
		List<Teacher> teachers = query.getResultList();
		if (teachers == null || teachers.isEmpty() || teachers.size() > 1)
			return null;

		return teachers.get(0);

	}

	@Override
	public List<Teaches> getTeaches(Teacher instructorId) {

		Query query = this.em.createQuery("from Teaches t where t.instructorId = :instructorId");

		query.setParameter("instructorId", instructorId);

		@SuppressWarnings("unchecked")
		List<Teaches> teaches = query.getResultList();

		if (teaches == null || teaches.isEmpty())
			return null;

		return teaches;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Teaches> getTeaches(Teacher teacher, int session, Department deptId) {

		Query query = this.em.createQuery(
				"select t from Teaches t where t.instructorId=:instructorId and t.courseId in (select c.courseId from Course c where c.session=:session and c.acceptingDept=:acceptingDept and c.hour > 0)");

		query.setParameter("instructorId", teacher);
		query.setParameter("session", session);
		query.setParameter("acceptingDept", deptId.getDeptCode());

		List<Teaches> teaches = query.getResultList();

		if (teaches == null || teaches.isEmpty())
			return null;

		return teaches;
	}

	@Override
	public Teaches getTeaches(Integer teachesId) {

		Query query = this.em.createQuery("from Teaches t where t.teachesId=:teachesId");
		query.setParameter("teachesId", teachesId);

		@SuppressWarnings("unchecked")
		List<Teaches> teaches = query.getResultList();
		if (teaches == null || teaches.isEmpty() || teaches.size() > 1)
			return null;

		return teaches.get(0);
	}

	@Override
	public List<Teaches> getTeaches(int session, Department deptId) {

		Query query = this.em.createQuery(
				"select t from Teaches t where t.courseId in (select c.courseId from Course c where c.session=:session and c.acceptingDept=:acceptingDept and c.hour > 0)");

		query.setParameter("session", session);
		query.setParameter("acceptingDept", deptId.getDeptCode());

		@SuppressWarnings("unchecked")
		List<Teaches> teaches = query.getResultList();

		if (teaches == null || teaches.isEmpty())
			return null;

		return teaches;
	}
}
