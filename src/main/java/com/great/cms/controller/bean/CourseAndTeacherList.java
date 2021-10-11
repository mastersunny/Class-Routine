package com.great.cms.controller.bean;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseAndTeacherList {

	List<CourseAndTeacher> teachesList;

	public List<CourseAndTeacher> getTeachesList() {
		return teachesList;
	}

	public void setTeachesList(List<CourseAndTeacher> teachesList) {
		this.teachesList = teachesList;
	}

	@Override
	public String toString() {
		return "CourseAndTeacherList [teachesList=" + teachesList + "]";
	}

}
