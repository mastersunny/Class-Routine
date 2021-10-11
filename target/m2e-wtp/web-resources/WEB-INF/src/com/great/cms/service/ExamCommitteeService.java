package com.great.cms.service;

import java.util.List;

import com.great.cms.db.entity.Exam;
import com.great.cms.db.entity.ExamCommittee;

public interface ExamCommitteeService {

	public ExamCommittee getExamCommitteeIdBySemAndDept(int semesterId,String deptCode);

	public ExamCommittee getExamCommittee(Exam exam, int semesterId);

	public ExamCommittee getExamCommitteeBySession(Exam exam, Integer session);

	public List<ExamCommittee> getCommittees(Exam exam);

	public ExamCommittee getExamCommitteeById(int id);
	
	ExamCommittee getExamCommitteeBySemester(int semester);
}
