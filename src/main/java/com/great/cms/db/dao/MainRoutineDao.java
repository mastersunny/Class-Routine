package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.Day;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.ExamCommittee;
import com.great.cms.db.entity.MainRoutine;

public interface MainRoutineDao extends GenericDao<MainRoutine, Integer> {

	public List<MainRoutine> getRoutineByExamCommIdAndDepiId(ExamCommittee examCommitteeId, Department deptId);

	public List<MainRoutine> getRoutineForRooms(Department department, Day day, ExamCommittee examCommittee);

}
