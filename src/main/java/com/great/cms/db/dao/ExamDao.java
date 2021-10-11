package com.great.cms.db.dao;

import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Exam;

public interface ExamDao extends GenericDao<Exam, Integer> {
	Exam getExamByDeptId(Department department);
}
