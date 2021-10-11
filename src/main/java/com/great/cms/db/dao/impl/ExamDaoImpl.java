package com.great.cms.db.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.ExamDao;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Exam;

@Repository("ExamDao")
public class ExamDaoImpl extends GenericDaoImpl<Exam, Integer> implements ExamDao {

	public ExamDaoImpl() {
		super(Exam.class);
	}

	@Override
	public Exam getExamByDeptId(Department department) {

		Query query = this.em
				.createQuery("from Exam e where current_date() between e.examStart and e.examEnd and e.deptId=:deptId");
		query.setParameter("deptId", department);
		return (Exam) query.getResultList().get(0);
	}

}
