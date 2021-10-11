package com.great.cms.controller;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.great.cms.controller.bean.DeptAndSemester;
import com.great.cms.controller.bean.SemesterBean;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Exam;
import com.great.cms.db.entity.ExamCommittee;
import com.great.cms.db.entity.MainRoutine;
import com.great.cms.service.DepartmentService;
import com.great.cms.service.ExamCommitteeService;
import com.great.cms.service.ExamService;
import com.great.cms.service.MainRoutineService;

@Controller
@RequestMapping("normal")
public class NormalUserController {

	@Autowired
	MainRoutineService mainRoutineService;

	@Autowired
	DepartmentService deptService;

	@Autowired
	ExamService examService;

	@Autowired
	ExamCommitteeService examCommitteeService;

	@RequestMapping(value = "/normalview", method = RequestMethod.GET)
	public String directSearch(DeptAndSemester deptAndSemester, Model model) {

		System.out.println("Showing routine for dept: " + deptAndSemester);

		String deptCode = deptAndSemester.getDeptCode();
		int semesterId = Integer.parseInt(deptAndSemester.getSemester());

		List<MainRoutine> routines = mainRoutineService.getRoutineByDeptAndSemester(deptCode, semesterId);

		model.addAttribute("routines", routines);
		model.addAttribute("deptCode", deptCode);
		model.addAttribute("semester", deptAndSemester.getSemester());

		return "normalview";

	}

	@RequestMapping("/getExamCommittees")
	@ResponseBody
	public String getExamCommittees(String deptCode) {

		System.out.println(deptCode);
		Department department = deptService.getDept(deptCode);
		Exam exam = (Exam) examService.getExam(department);
		List<ExamCommittee> examCommittees = null;

		if (exam != null) {
			examCommittees = examCommitteeService.getCommittees(exam);
		}
		System.out.println(examCommittees);

		List<SemesterBean> semesters = new ArrayList<>();

		if (examCommittees != null) {

			for (ExamCommittee examCommittee : examCommittees) {

				SemesterBean semester = new SemesterBean();

				if (examCommittee.getSemester() == 11) {
					semester.setId(11);
					semester.setName("1/1");
				}
				if (examCommittee.getSemester() == 21) {
					semester.setId(21);
					semester.setName("2/1");
				}
				if (examCommittee.getSemester() == 31) {
					semester.setId(31);
					semester.setName("3/1");
				}
				if (examCommittee.getSemester() == 41) {
					semester.setId(41);
					semester.setName("4/1");
				}
				if (examCommittee.getSemester() == 12) {
					semester.setId(12);
					semester.setName("1/2");
				}
				if (examCommittee.getSemester() == 22) {
					semester.setId(22);
					semester.setName("2/2");
				}
				if (examCommittee.getSemester() == 32) {
					semester.setId(32);
					semester.setName("3/2");
				}
				if (examCommittee.getSemester() == 42) {
					semester.setId(42);
					semester.setName("4/2");
				}

				semesters.add(semester);

				System.out.println(semester.getName());
			}

			ObjectMapper mapper = new ObjectMapper();
			String value = null;

			try {
				value = mapper.writeValueAsString(semesters);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return value;
		}

		return "no";

	}

}
