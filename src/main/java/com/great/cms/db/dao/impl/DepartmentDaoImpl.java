package com.great.cms.db.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.db.dao.DepartmentDao;
import com.great.cms.db.entity.Department;

@Repository("DepartmentDao")
public class DepartmentDaoImpl extends GenericDaoImpl<Department, Integer>
		implements DepartmentDao {

	public DepartmentDaoImpl() {
		super(Department.class);
	}

	@Override
	public Department getDeptIdByDeptCode(String deptCode) {
		// TODO Auto-generated method stub
		Query query = em.createNamedQuery("Department.findByDeptCode")
				.setParameter("deptCode", deptCode);

		Department dept = (Department) query.getResultList().get(0);
		
//		System.out.println(dept.getDeptId());

		return dept;
	}

	@Override
	public List<String> getDeptName() {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("select d.deptName from Department d");
		return null;
	}

	@Override
	@Transactional
	public Department getDeptByDeptCode(String deptCode) {
		
		
		Query query = this.em.createNamedQuery("Department.findByDeptCode")
				.setParameter("deptCode", deptCode);
		Department department = (Department) query.getResultList().get(0);
		return department;
	}
}
