package com.great.cms.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.db.dao.CourseRegDao;
import com.great.cms.db.entity.CourseReg;



/**
 * 
 * @author sknabil
 *
 */
@Repository("CourseRegistrationDao")
public class CourseRegDaoImpl extends GenericDaoImpl<CourseReg, Integer> implements CourseRegDao {

	public CourseRegDaoImpl () {
		super ( CourseReg.class );
	}

	@SuppressWarnings("unchecked")
	//@Override
	@Transactional(readOnly = true)
	public List<CourseReg> getRegByIdStudent(int id) {
		List<CourseReg> list = null;
		//public ConfUser getConfUserByAccctMsisdn(long acctMsisdn){
		CourseReg courseReg = null;
			try{
				courseReg = (CourseReg) em.createQuery("select o from " + type.getName() + " o where o.idStudent.idStudent ="+id+" ").getResultList();
				String query = "select o from " + type.getName() + " o where " +
     				   "o.idStudent.idStudent = ?1 " +
     				   "order by o.idStudent ";
     	list = em.createQuery(query)
     			 .setParameter(1, id)
     			 .getResultList();
				
     	list = (List<CourseReg>) courseReg;
     	
     		}
			catch(Exception e){
				System.out.println("*******failure*******");
	        }
			System.out.println("*******successful*******");
			return list;
		//}
	}

	@Override
	public List<CourseReg> getRegistrationByIdStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
