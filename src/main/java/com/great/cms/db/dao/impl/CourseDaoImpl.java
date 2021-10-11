package com.great.cms.db.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.db.dao.CourseDao;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Teaches;

@Repository("CourseDao")
public class CourseDaoImpl extends GenericDaoImpl<Course, Integer> implements CourseDao {

	public CourseDaoImpl() {
		super(Course.class);
	}

	@Override
	@Transactional
	public Integer getCourseIdByCourseCode(String courseCode) {
		// TODO Auto-generated method stub
		Query query = this.em.createNamedQuery("Course.findByCourseCode").setParameter("courseCode", courseCode);

		Course course = (Course) query.getResultList().get(0);

		System.out.println(course);

		return course.getCourseId();
	}

	@Override
	@Transactional
	public Course getCourseByCode(String courseCode) {
		// TODO Auto-generated method stub

		Query query = this.em.createNamedQuery("Course.findByCourseId").setParameter("courseId",
				this.getCourseIdByCourseCode(courseCode));

		Course course = (Course) query.getResultList().get(0);

		System.out.println(course);

		return course;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Course> getCourseByAcceptingDept(String deptCode) {

		Query query = this.em.createQuery("from Course c where c.acceptingDept=:acceptingDept");
		query.setParameter("acceptingDept", deptCode);

		return query.getResultList();
	}

	@Override
	public List<Course> getCourses(int session, Department deptId) {

		Query query = this.em.createQuery(
				"from Course c where c.session=:session and c.acceptingDept=:acceptingDept and c.hour > 0");

		query.setParameter("session", session);
		query.setParameter("acceptingDept", deptId.getDeptCode());

		@SuppressWarnings("unchecked")
		List<Course> courses = query.getResultList();

		if (courses == null || courses.isEmpty())
			return null;

		return courses;
	}

	// @Override
	// public String getCourseCodeByCourseId(Integer courseId) {
	// // TODO Auto-generated method stub
	//
	// Query query = this.em.createNamedQuery("Course.findByCourseId");
	// Course course = (Course) query.getResultList().get(1);
	// return course.getCourseCode();
	// }

}
