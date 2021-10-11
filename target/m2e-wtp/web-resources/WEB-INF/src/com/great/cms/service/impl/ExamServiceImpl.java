package com.great.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.ExamDao;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Exam;
import com.great.cms.service.ExamService;

@Service("examService")
public class ExamServiceImpl implements ExamService{

	@Autowired
	ExamDao examDao;
	
	
	@Override
	public Exam getExam(Department department) {
		
		return examDao.getExamByDeptId(department);
	}

}
