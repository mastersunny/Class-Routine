package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.DepartmentDao;
import com.great.cms.db.entity.Department;
import com.great.cms.service.DepartmentService;

@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDao deptDao;
	
	@Override
	public List<Department> getDept() {
		// TODO Auto-generated method stub
		return (List<Department>)(deptDao.findAll());
	}

	@Override
	public List<String> getDeptName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getDept(String deptCode) {
			
		return deptDao.getDeptByDeptCode(deptCode);
	}

	@Override
	public Department getDeptById(int dept) {
		
		Department department = deptDao.findById(dept);
		return department;
	}

	@Override
	public List<Department> getDepts() {
		
		List<Department> depts = deptDao.findAll();
		return depts;
	}

}

