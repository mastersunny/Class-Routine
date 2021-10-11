package com.great.cms.db.dao;

import com.great.cms.db.entity.Day;

public interface DayDao extends GenericDao<Day, Integer> {
	
	Day getDay(int i);

}
