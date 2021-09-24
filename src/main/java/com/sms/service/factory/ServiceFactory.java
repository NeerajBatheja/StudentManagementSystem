package com.sms.service.factory;

import java.util.HashMap;
import java.util.Map;

import com.sms.dao.Dao;
import com.sms.dao.UserDao;
import com.sms.dao.admin.AdminCourseDao;
import com.sms.dao.student.CourseDao;
import com.sms.dao.student.StudentCourseDao;
import com.sms.model.StudentCourse;
import com.sms.service.*;
import com.sms.service.admin.impl.AdminCourseService;
import com.sms.service.student.impl.CourseService;
import com.sms.service.student.impl.FeeService;
import com.sms.service.student.impl.GradeService;
import com.sms.service.student.impl.UserService;

public class ServiceFactory {

	// private constructor
	// static method
	// normal public method
	// static obj

	ServiceFactory() {
		init();
	}

	private static ServiceFactory instance = new ServiceFactory();
	private Map<String, Object> getInstanceOf = new HashMap<String, Object>();

	public static ServiceFactory getInstance() {

		return instance;
	}

	public Iservice getService(String str) {

		return (Iservice) getInstanceOf.get(str);

		/*
		 * if(str.equalsIgnoreCase("courseservice")) { return new CourseService(); }
		 * 
		 * if(str.equalsIgnoreCase("gradeservice")) { return new GradeService(); }
		 * 
		 * if(str.equalsIgnoreCase("userservice")) { return new UserService(); }
		 * if(str.equalsIgnoreCase("admincourseservice")) { return new
		 * AdminCourseService(); }
		 * 
		 * 
		 * return null;
		 */

	}

	private Map<String, Object> init() {

		getInstanceOf.put("courseservice", new CourseService());
		getInstanceOf.put("gradeservice", new GradeService());
		getInstanceOf.put("userservice", new UserService());
		getInstanceOf.put("admincourseservice", new AdminCourseService());
		getInstanceOf.put("feeservice", new FeeService());
		return getInstanceOf;
	}

	public UserServiceInterface getUserService(String str) {

		if (str.equalsIgnoreCase("userservice")) {
			return new UserService();
		}
		return null;

	}

}
