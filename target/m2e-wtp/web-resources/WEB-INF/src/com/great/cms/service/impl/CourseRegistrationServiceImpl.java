package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.CourseRegDao;
import com.great.cms.db.entity.CourseReg;
import com.great.cms.service.CourseRegService;


@Repository
@Service("CourseRegistrationService")
public class CourseRegistrationServiceImpl implements CourseRegService, Serializable {
//	private Logger logger = LoggerFactory.getLogger(this.getClass().getPackage().getName());
	
	@Autowired
	private CourseRegDao courseRegDao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7468488836689400267L;

	@Override
	public List<CourseReg> getStudentRegistration(int id) {
		// TODO Auto-generated method stub
		List<CourseReg> courseRegList = courseRegDao.getRegistrationByIdStudent(id);
		//System.out.println("$"+courseReg.getIdStudent().getRegistrationNo());
		if(courseRegList != null && courseRegList.size()>0){
			for(CourseReg courseReg : courseRegList){
				//System.out.println("##"+courseReg.getIdStudent().getName());
		
		}
		}
//		logger.info("Id::::"+courseReg.getIdStudent().getRegistrationNo());
		return courseRegList;
	
	}
	
	
}
