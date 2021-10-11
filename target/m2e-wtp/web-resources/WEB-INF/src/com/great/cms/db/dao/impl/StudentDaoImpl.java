package com.great.cms.db.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.db.dao.StudentDao;
import com.great.cms.db.entity.Student;

@Repository("StudentDao")
public class StudentDaoImpl extends GenericDaoImpl<Student, Integer> implements StudentDao {

	public StudentDaoImpl() {
		super(Student.class);
	}

	@Override
	@Transactional
	public Student getStudentByReg(Integer reg) {

		Query query = this.em.createNamedQuery("Student.findByRegistrationNo");
		query.setParameter("registrationNo", reg);

		return (Student) (query.getResultList().get(0));
	}
}
