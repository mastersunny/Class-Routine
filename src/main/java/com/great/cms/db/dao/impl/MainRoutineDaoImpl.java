package com.great.cms.db.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.db.dao.MainRoutineDao;
import com.great.cms.db.entity.Day;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.ExamCommittee;
import com.great.cms.db.entity.MainRoutine;

@Repository("MainRoutineDao")
public class MainRoutineDaoImpl extends GenericDaoImpl<MainRoutine, Integer> implements MainRoutineDao {

	public MainRoutineDaoImpl() {
		super(MainRoutine.class);
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<MainRoutine> getRoutineByExamCommIdAndDepiId(ExamCommittee examCommitteeId, Department deptId) {

		Query query = em
				.createQuery("from MainRoutine mr where mr.examCommitteeId = :examCommitteeId and mr.deptId = :deptId");
		query.setParameter("examCommitteeId", examCommitteeId).setParameter("deptId", deptId);

		List<MainRoutine> routines = query.getResultList();
		return routines;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<MainRoutine> getRoutineForRooms(Department department, Day day, ExamCommittee examCommittee) {

		Query query = em.createQuery(
				"from MainRoutine mr where mr.examCommitteeId = :examCommitteeId and mr.dayId = :dayId and mr.deptId = :deptId");

		query.setParameter("examCommitteeId", examCommittee);
		query.setParameter("deptId", department);
		query.setParameter("dayId", day);

		List<MainRoutine> routines = query.getResultList();
		if (routines == null || routines.isEmpty())
			return null;
		return routines;
	}

}