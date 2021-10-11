package com.great.cms.controller.bean;

public class ConfirmBean {

	private String name;
	private String regNumber;
	private String email;
	private String session;
	private String deptName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "ConfirmBean [name=" + name + ", regNumber=" + regNumber
				+ ", email=" + email + ", session=" + session + ", deptName="
				+ deptName + "]";
	}
	
	
	

}
