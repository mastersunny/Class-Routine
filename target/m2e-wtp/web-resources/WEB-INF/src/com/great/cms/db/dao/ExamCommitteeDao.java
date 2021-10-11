package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Exam;
import com.great.cms.db.entity.ExamCommittee;

public interface ExamCommitteeDao extends GenericDao<ExamCommittee, Integer> {
	//
	// public int getExamCommitteeIdBySem(int semesterId);
	// public ExamCommittee getExamCommitteeBySem(int semesterId);
	public ExamCommittee getExamCommitteeIdBySemAndDept(int semesterId, String deptCode);

	// public int getExamCommitteeIdBySemAndSessionAndDept(int semesterId , int
	// session , int deptId);
	public ExamCommittee getExamCommitteeDeptId(Department deptId);

	public ExamCommittee getExamCommitteeByCurrentTimeAndDeptId(Department deptId, Integer semester);

	public ExamCommittee getExamCommitteeByExamIdAndSemId(Exam exam, int semesterId);

	public ExamCommittee getExamCommitteeByExamIdAndSession(Exam exam, Integer session);

	public List<ExamCommittee> getExamCommittees(Exam exam);
	
	ExamCommittee getExamCommittee(int semester);
}
