package com.great.cms.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.great.cms.db.entity.MainRoutine;
import com.great.cms.db.entity.Student;
import com.great.cms.service.DepartmentService;
import com.great.cms.service.ExamCommitteeService;
import com.great.cms.service.ExamService;
import com.great.cms.service.MainRoutineService;
import com.great.cms.service.StudentService;
import com.great.cms.service.TeacherService;

@Controller
@RequestMapping("student")
public class StudentController {

	@Autowired
	MainRoutineService mainRoutineService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	StudentService studentService;

	@Autowired
	ExamCommitteeService examCommitteeService;

	@Autowired
	ExamService examService;

	@Autowired
	TeacherService teacherService;

	@RequestMapping({ "/studentview", "/", "" })
	public String studentView(Model model, Principal principal) {

		String username = principal.getName();

		System.out.println(username);
		System.out.println("IN STUDENT CONTROLLER");

		Student student = (Student) studentService.getStudentByReg(Integer.parseInt(username));

		List<MainRoutine> routines = mainRoutineService.getRoutineForStudent(student);

		model.addAttribute("deptCode", student.getDeptId().getDeptCode());
		model.addAttribute("routines", routines);
		model.addAttribute("student", student);

		int semester = 0;
		if (routines != null) {

			semester = routines.get(0).getExamCommitteeId().getSemester();
			model.addAttribute("semester", semester);
		}

		return "studentview";
	}

	@RequestMapping("/profile")
	public String showStudent(Model model, @RequestParam Integer regNo) {
		
		
		Student student = (Student) studentService.getStudentByReg(regNo);
		
		System.out.println(student);
		
		
		model.addAttribute("student", student);
		model.addAttribute("flag", false);
		return "profile";
	}

}
