package com.sms.service.admin.impl;

import java.util.List;
import java.util.Optional;

import com.sms.dao.factory.DaoFactory;
import com.sms.model.StudentCoursesJoin;
import com.sms.model.User;
import com.sms.service.Iservice;

public class AdminCourseService implements Iservice<StudentCoursesJoin> {

	@Override
	public Optional<StudentCoursesJoin> get(StudentCoursesJoin id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentCoursesJoin> getAll() {
		// TODO Auto-generated method stub
		
		
		return DaoFactory.getInstance().getDao("admincourse").getAll();
	}
	public List<StudentCoursesJoin> getAll(User user) {
		// TODO Auto-generated method stub
		
		
		return DaoFactory.getInstance().getDao("admincourse").getAll(user);
	}


	@Override
	public void update(StudentCoursesJoin studentcoursejoin, String[] params) {
		// TODO Auto-generated method stub
		DaoFactory.getInstance().getDao("admincourse").update(studentcoursejoin, null);
	}

	@Override
	public void delete(StudentCoursesJoin t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(StudentCoursesJoin t) {
		// TODO Auto-generated method stub
		return false;
	}

}
