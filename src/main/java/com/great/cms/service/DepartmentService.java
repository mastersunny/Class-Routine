package com.great.cms.service;

import java.util.List;

import com.great.cms.db.entity.Department;

public interface DepartmentService {

	public List<Department> getDept();
	public List<String> getDeptName();
	public Department getDept(String deptCode);
	public Department getDeptById(int dept);
	public List<Department> getDepts();
}
