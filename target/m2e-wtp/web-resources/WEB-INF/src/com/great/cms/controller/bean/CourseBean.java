package com.great.cms.controller.bean;

import java.math.BigDecimal;

import com.great.cms.db.entity.GeneralType;

public class CourseBean {

	private String courseCode;
	private String courseTitle;
	private int semester;
	private int session;
	private String offeringDept;
	private BigDecimal credit;
	private int generalTypeId;
	
	

//	public CourseBean() {
//		
//	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}

	public String getOfferingDept() {
		return offeringDept;
	}

	public void setOfferingDept(String offeringDept) {
		this.offeringDept = offeringDept;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	public int getGeneralTypeId() {
		return generalTypeId;
	}

	public void setGeneralTypeId(int generalTypeId) {
		this.generalTypeId = generalTypeId;
	}

	

}
