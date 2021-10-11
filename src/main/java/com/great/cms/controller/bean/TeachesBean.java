package com.great.cms.controller.bean;

public class TeachesBean {

	private int teachesId;
	private String courseCode;
	private int hour;

	public int getTeachesId() {
		return teachesId;
	}

	public void setTeachesId(int teachesId) {
		this.teachesId = teachesId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		return "TeachesBean [teachesId=" + teachesId + ", courseCode="
				+ courseCode + ", hour=" + hour + "]";
	}
	
	

}
