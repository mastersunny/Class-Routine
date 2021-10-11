package com.great.cms.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.ExamCommitteeDao;
import com.great.cms.db.entity.Exam;
import com.great.cms.db.entity.ExamCommittee;
import com.great.cms.service.ExamCommitteeService;

@Service("ExamCommitteeService")
public class ExamCommitteeServiceImpl implements ExamCommitteeService {

	@Autowired
	ExamCommitteeDao examCommitteeDao;

	public static Integer getCurrentSession() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

		String year = (String) timeStamp.substring(0, 4);
		int session = Integer.parseInt(year);

		return session;
	}

	@Override
	public ExamCommittee getExamCommitteeIdBySemAndDept(int semesterId, String deptCode) {

		ExamCommittee examCommitteeId = examCommitteeDao.getExamCommitteeIdBySemAndDept(semesterId, deptCode);

		System.out.println(examCommitteeId);

		return examCommitteeId;

	}

	@Override
	public ExamCommittee getExamCommittee(Exam exam, int semesterId) {

		return examCommitteeDao.getExamCommitteeByExamIdAndSemId(exam, semesterId);
	}

	@Override
	public ExamCommittee getExamCommitteeBySession(Exam exam, Integer session) {

		return examCommitteeDao.getExamCommitteeByExamIdAndSession(exam, session);
	}

	@Override
	public List<ExamCommittee> getCommittees(Exam exam) {

		List<ExamCommittee> examCommittees = examCommitteeDao.getExamCommittees(exam);
		return examCommittees;
	}

	@Override
	public ExamCommittee getExamCommitteeById(int id) {

		return examCommitteeDao.findById(id);

	}

	@Override
	public ExamCommittee getExamCommitteeBySemester(int semester) {

		return examCommitteeDao.getExamCommittee(semester);
	}

}
