package com.great.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.StudentDao;
import com.great.cms.db.entity.Student;
import com.great.cms.service.StudentService;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public Student getStudentByReg(Integer reg) {
		// TODO Auto-generated method stub

		Student student = studentDao.getStudentByReg(reg);

		return student;
	}
}
