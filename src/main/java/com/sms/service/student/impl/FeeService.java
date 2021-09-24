package com.sms.service.student.impl;

import java.util.List;
import java.util.Optional;

import com.sms.dao.factory.DaoFactory;
import com.sms.model.Course;
import com.sms.model.Fee;
import com.sms.model.StudentCourse;
import com.sms.model.User;
import com.sms.service.CourseServiceInterface;
import com.sms.service.Iservice;

public class FeeService implements Iservice<Fee> {

	@Override
	public Optional<Fee> get(Fee id) {
		// TODO Auto-generated method stub
		
		return DaoFactory.getInstance().getDao("feedao").get(id);
	}

	@Override
	public List<Fee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fee> getAll(User user) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void update(Fee t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Fee t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(Fee t) {
		// TODO Auto-generated method stub
		return false;
	}

}
