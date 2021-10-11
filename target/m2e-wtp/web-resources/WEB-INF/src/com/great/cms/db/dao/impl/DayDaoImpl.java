package com.great.cms.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.DayDao;
import com.great.cms.db.entity.Day;
import javax.persistence.Query;

@Repository("DayDao")
public class DayDaoImpl extends GenericDaoImpl<Day, Integer> implements DayDao {

	public DayDaoImpl() {
		super(Day.class);
	}

	@Override
	public Day getDay(int dayId) {
		
		Query query = this.em.createQuery("from Day d where d.dayId =:dayId");
		query.setParameter("dayId", dayId);
		
		Day day = (Day) query.getResultList().get(0);
		
		return day;
	}
	
	
}
