package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.MainRoutineDao;
import com.great.cms.db.entity.Day;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Exam;
import com.great.cms.db.entity.ExamCommittee;
import com.great.cms.db.entity.MainRoutine;
import com.great.cms.db.entity.Student;
import com.great.cms.service.DepartmentService;
import com.great.cms.service.ExamCommitteeService;
import com.great.cms.service.ExamService;
import com.great.cms.service.MainRoutineService;
import com.great.cms.service.StudentService;
import com.great.cms.utils.Session;

@Service("mainRoutineService")
public class MainRoutineServiceImpl implements MainRoutineService, Serializable {

	@Autowired
	MainRoutineDao mainRouitineDao;

	private static final long serialVersionUID = 1L;

	@Autowired
	MainRoutineDao mainRoutineDao;

	@Autowired
	DepartmentService deptService;

	@Autowired
	ExamService examService;

	@Autowired
	ExamCommitteeService examCommitteeService;

	@Autowired
	StudentService studentService;

	@Override
	public List<MainRoutine> getRoutineByDeptAndSemester(String deptCode, int semesterId) {

		System.out.println("Entered mainRoutineService");
		Department department = (Department) deptService.getDept(deptCode);
		System.out.println("Department is:: " + department);
		Exam exam = (Exam) examService.getExam(department);
		System.out.println("Exam is :: " + exam);
		ExamCommittee examCommittee = (ExamCommittee) examCommitteeService.getExamCommittee(exam, semesterId);

		List<MainRoutine> routines = mainRoutineDao.getRoutineByExamCommIdAndDepiId(examCommittee, department);

		return routines;
	}

	@Override
	public List<MainRoutine> getRoutineForStudent(Student student) {

		Department department = (Department) deptService.getDept(student.getDeptId().getDeptCode());
		Exam exam = (Exam) examService.getExam(department);
		Integer session = Session.getSessionById(Integer.toString(student.getRegistrationNo()));
		ExamCommittee examCommittee = (ExamCommittee) examCommitteeService.getExamCommitteeBySession(exam, session);

		List<MainRoutine> routines = mainRoutineDao.getRoutineByExamCommIdAndDepiId(examCommittee, department);

		return routines;
	}

	@Override
	public List<MainRoutine> getRoutineForRooms(Department department, Day day, ExamCommittee examCommittee) {

		List<MainRoutine> routines = mainRoutineDao.getRoutineForRooms(department, day, examCommittee);

		return routines;
	}

	@Override
	public boolean update(MainRoutine mainroutine) {
		// TODO Auto-generated method stub

		try {
			mainRouitineDao.update(mainroutine);
			return true;
		} catch (RuntimeException r) {
			System.out.println(r.getMessage());
		}
		return false;

	}

	@Override
	public List<MainRoutine> getRoutineForTeacher(Department department, ExamCommittee examCommittee) {

		List<MainRoutine> routines = mainRoutineDao.getRoutineByExamCommIdAndDepiId(examCommittee, department);

		return routines;
	}

	@Override
	public boolean deleteById(int mainRoutineId) {

		try {

			mainRouitineDao.deleteById(mainRoutineId);
			return true;
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

		return false;

	}

	@Override
	public boolean addRoutine(MainRoutine mainRoutine) {

		try {

			mainRouitineDao.save(mainRoutine);
			return true;

		} catch (RuntimeException e) {

			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public MainRoutine getRoutineById(Integer mainRoutineId) {

		return mainRouitineDao.findById(mainRoutineId);

	}

}
