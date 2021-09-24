package com.sms.dao.factory;

import java.util.HashMap;
import java.util.Map;

import com.sms.dao.Dao;
import com.sms.dao.UserDao;
import com.sms.dao.admin.AdminCourseDao;
import com.sms.dao.student.CourseDao;
import com.sms.dao.student.FeeDao;
import com.sms.dao.student.StudentCourseDao;
import com.sms.model.StudentCourse;

public class DaoFactory {

	// private constructor
	// static method
	// static obj

	private DaoFactory() {
		init();
	}
	private	Map<String, Object> daoMap = new HashMap<String, Object>();
	private static DaoFactory instance = new DaoFactory();

	public static DaoFactory getInstance() {

		return instance;
	}
	// DaoFactory.getInstance().getDao("course");

	public Dao getDao(String str) {
	//	Map<String, Object> getInstanceOf = init();

		return (Dao) daoMap.get(str);
		/*
		 * if(str.equalsIgnoreCase("coursedao")) { return new CourseDao(); }
		 * 
		 * if(str.equalsIgnoreCase("userdao")) { return new UserDao(); }
		 * 
		 * if(str.equalsIgnoreCase("studentcourse")) { return new StudentCourseDao(); }
		 * if(str.equalsIgnoreCase("admincourse")) { return new AdminCourseDao(); }
		 */
		// return null;

	}

	private void  init() {
		

		daoMap.put("coursedao", new CourseDao());
		daoMap.put("userdao", new UserDao());
		daoMap.put("studentcourse", new StudentCourseDao());
		daoMap.put("admincourse", new AdminCourseDao());
		daoMap.put("feedao", new FeeDao());
		//return daoMap;
	}

}
