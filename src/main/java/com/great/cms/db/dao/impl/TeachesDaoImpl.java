package com.great.cms.db.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.CourseDao;
import com.great.cms.db.dao.TeacherDao;
import com.great.cms.db.dao.TeachesDao;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.Teacher;
import com.great.cms.db.entity.Teaches;

@Repository("TeachesDao")
public class TeachesDaoImpl extends GenericDaoImpl<Teaches, Integer> implements TeachesDao {

	@Autowired
	private CourseDao courseDao;
	@Autowired
	private TeacherDao teacherDao;

	public TeachesDaoImpl() {
		super(Teaches.class);
	}

	@Override
	public Integer getCourseIdByTeachesId(Integer teachesId) {
		// TODO Auto-generated method stub
		Query query = this.em.createNamedQuery("Teaches.findByTeachesId");
		Course courseId = (Course) (query.getResultList().get(1));
		return courseId.getCourseId();
	}

	@Override
	public Long getTeacherIdByTeachesId(Integer teachesId) {
		// TODO Auto-generated method stub
		Query query = this.em.createNamedQuery("Teaches.findByTeachesId");
		Teacher teacherId = (Teacher) (query.getResultList().get(2));
		return teacherId.getInstructorId();
	}

	@Override
	public List<Teaches> getTeaches(int session, String deptCode) {

		Query query = this.em.createQuery(
				"select t from Teaches t where  t.courseId in (select c.courseId from Course c where c.session=:session and c.acceptingDept=:acceptingDept and c.hour > 0)");

		query.setParameter("session", session);
		query.setParameter("acceptingDept", deptCode);

		@SuppressWarnings("unchecked")
		List<Teaches> teaches = query.getResultList();

		if (teaches == null || teaches.isEmpty())
			return null;

		return teaches;
	}

	@Override
	public Teaches getTeaches(Course courseId, Teacher instructorId) {

		Query query = this.em
				.createQuery("from Teaches t where t.courseId =:courseId and t.instructorId =:instructorId");

		query.setParameter("courseId", courseId);
		query.setParameter("instructorId", instructorId);

		Teaches teaches = (Teaches) query.getResultList().get(0);

		return teaches;
	}

}
