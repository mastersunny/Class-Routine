package com.great.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.great.cms.db.entity.Course;
import com.great.cms.service.CourseRegService;
import com.great.cms.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private CourseRegService courseRegService;

	@RequestMapping("/course")
	public String getCourse(Model model) {
		List<Course> courses = courseService.getCourseList();// courseRepository.findAll();
		model.addAttribute("courses", courses);
		
		System.out.println("ok");

//		List<CourseReg> courseRegList = courseRegService
//				.getStudentRegistration(2);
		// System.out.println("####"+);
		return "course";
	}

}
