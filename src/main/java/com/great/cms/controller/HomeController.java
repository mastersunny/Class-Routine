package com.great.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Exam;
import com.great.cms.db.entity.ExamCommittee;
import com.great.cms.service.DepartmentService;
import com.great.cms.service.ExamCommitteeService;
import com.great.cms.service.ExamService;

@Controller("homeController")
public class HomeController {

	@Autowired
	ExamCommitteeService examCommitteeService;
	@Autowired
	ExamService examService;
	@Autowired
	DepartmentService deptService;

	@RequestMapping("/")
	public String showIndex(Model model) {

		List<Department> depts = deptService.getDepts();
		Exam exam = null;
		List<ExamCommittee> examCommittees = null;

		if (depts != null) {

			for (Department department : depts) {

				exam = (Exam) examService.getExam(department);
				if (exam != null) {
					examCommittees = examCommitteeService.getCommittees(exam);
					if (examCommittees != null) {
						break;
					}

				}
			}

		}

		model.addAttribute("depts", depts);
		model.addAttribute("examCommittees", examCommittees);

		return "home";
	}
}
