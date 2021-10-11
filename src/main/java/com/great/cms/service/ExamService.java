package com.great.cms.service;

import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Exam;

public interface ExamService {
	
	public Exam getExam(Department department);

}
