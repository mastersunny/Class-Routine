package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.Department;

public interface DepartmentDao extends GenericDao<Department, Integer> {

	public Department getDeptIdByDeptCode(String deptCode);
	public List<String> getDeptName();
	public Department getDeptByDeptCode(String deptCode);
}
