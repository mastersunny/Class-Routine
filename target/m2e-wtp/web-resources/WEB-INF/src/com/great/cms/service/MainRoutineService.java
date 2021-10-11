package com.great.cms.service;

import java.util.List;

import com.great.cms.db.entity.Day;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.ExamCommittee;
import com.great.cms.db.entity.MainRoutine;
import com.great.cms.db.entity.Student;

public interface MainRoutineService {

	
	public List<MainRoutine> getRoutineByDeptAndSemester(String deptCode,
			int semesterId);

	public List<MainRoutine> getRoutineForStudent(Student student);

	public List<MainRoutine> getRoutineForRooms(Department department, Day day,
			ExamCommittee examCommittee);

	public boolean update(MainRoutine mainroutine);

	public List<MainRoutine> getRoutineForTeacher(Department department,
			ExamCommittee examCommittee);

	public boolean deleteById(int mainRoutineId);

	public boolean addRoutine(MainRoutine mainRoutine);

	public MainRoutine getRoutineById(Integer mainRoutineId);

	

	
	
	
	
}
