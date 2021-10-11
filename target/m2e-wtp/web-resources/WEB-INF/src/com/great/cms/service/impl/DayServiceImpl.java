package com.great.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.DayDao;
import com.great.cms.db.entity.Day;
import com.great.cms.service.DayService;

@Service
public class DayServiceImpl implements DayService{
	
	@Autowired
	private DayDao dayDao;

	@Override
	public Day getDay(int dayId) {
		
		return dayDao.findById(dayId);
	}

}
