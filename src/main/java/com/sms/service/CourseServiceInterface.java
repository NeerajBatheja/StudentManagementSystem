package com.sms.service;

import java.util.List;

import com.sms.exception.AlreadyExistException;
import com.sms.exception.GeneralException;
import com.sms.model.Course;
import com.sms.model.StudentCourse;
import com.sms.model.User;

public interface CourseServiceInterface<T>  {
	
	boolean register(T t) throws AlreadyExistException;
	
	 List<T> getRegisterCourse(User user);

	

	

}
