package com.great.cms.controller.bean;

public class DeptAndSemester {

	private String deptCode;
	private String semester;

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "SearchDirect [deptCode=" + deptCode + ", semester=" + semester + "]";
	}

}
