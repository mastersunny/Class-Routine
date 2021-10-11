package com.great.cms.db.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.db.dao.ExamCommitteeDao;
import com.great.cms.db.dao.ExamDao;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Exam;
import com.great.cms.db.entity.ExamCommittee;

@Repository("ExamCommitteeDao")
public class ExamCommitteeDaoImpl extends GenericDaoImpl<ExamCommittee, Integer> implements ExamCommitteeDao {

	public ExamCommitteeDaoImpl() {
		super(ExamCommittee.class);
	}

	@Autowired
	ExamDao examDao;

	@Override
	public ExamCommittee getExamCommitteeIdBySemAndDept(int semesterId, String deptCode) {

		Query query = em.createQuery("select exam_id from Exam xm order by xm.id desc where xm.dept_id = :dept_id");
		query.setParameter("dept_id", 1);

		System.out.println(query.setMaxResults(1).getResultList());
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public ExamCommittee getExamCommitteeDeptId(Department deptId) {
		Query query = this.em.createQuery(
				"FROM ExamCommittee ec WHERE ec.startDate <= current_date() AND current_date() <= ec.endDate AND examId = :examId");
		query.setParameter("examId", examDao.getExamByDeptId(deptId));
		ExamCommittee examCommitteeId = (ExamCommittee) query.getResultList().get(0);

		System.out.println(examCommitteeId);

		return examCommitteeId;
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public ExamCommittee getExamCommitteeByCurrentTimeAndDeptId(Department deptId, Integer semester) {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery(
				"FROM ExamCommittee ec WHERE ec.startDate <= current_date() AND current_date() <= ec.endDate AND examId = :examId AND semester = :semester");
		query.setParameter("examId", examDao.getExamByDeptId(deptId));
		query.setParameter("semester", semester);
		ExamCommittee examCommitteeId = (ExamCommittee) query.getResultList().get(0);

		System.out.println(examCommitteeId);
		return examCommitteeId;
	}

	@Override
	@Transactional
	public ExamCommittee getExamCommitteeByExamIdAndSemId(Exam exam, int semesterId) {
		Query query = this.em.createQuery("from ExamCommittee e where e.examId=:examId and semester =:semester");
		query.setParameter("examId", exam);
		query.setParameter("semester", semesterId);

		ExamCommittee examCommittee = (ExamCommittee) query.getResultList().get(0);
		return examCommittee;
	}

	@Override
	@Transactional
	public ExamCommittee getExamCommitteeByExamIdAndSession(Exam exam, Integer session) {

		Query query = this.em.createQuery("from ExamCommittee  e where e.examId=:examId and session =:session");
		query.setParameter("examId", exam);
		query.setParameter("session", session);

		ExamCommittee examCommittee = (ExamCommittee) query.getResultList().get(0);
		return examCommittee;
	}

	@Override
	public List<ExamCommittee> getExamCommittees(Exam exam) {

		Query query = this.em.createQuery("from ExamCommittee e where e.examId =:examId");
		query.setParameter("examId", exam);

		@SuppressWarnings("unchecked")
		List<ExamCommittee> examCommittees = query.getResultList();

		if (examCommittees == null || examCommittees.isEmpty()) {
			return null;
		}

		return examCommittees;
	}

	@Override
	public ExamCommittee getExamCommittee(int semester) {

		Query query = this.em.createQuery("from ExamCommittee e where e.semester =:semester");
		query.setParameter("semester", semester);

		ExamCommittee examCommittee = (ExamCommittee) query.getResultList().get(0);

		return examCommittee;
	}

}
