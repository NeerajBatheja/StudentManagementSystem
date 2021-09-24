package com.sms.service.student.impl;

import java.util.List;

import org.apache.el.stream.Optional;

import com.sms.dao.Dao;
import com.sms.dao.factory.DaoFactory;
import com.sms.dao.student.CourseDao;
import com.sms.dao.student.StudentCourseDao;
import com.sms.exception.AlreadyExistException;
import com.sms.exception.GeneralException;
import com.sms.exception.ValidationException;
import com.sms.model.Course;
import com.sms.model.StudentCourse;
import com.sms.model.User;
import com.sms.service.CourseServiceInterface;
import com.sms.service.Iservice;

public class CourseService implements Iservice<Course>, CourseServiceInterface<StudentCourse> {

	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		Dao<Course> dao = new CourseDao();

		return dao.getAll();
	}

	@Override
	public void update(Course t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Course t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean add(Course course) throws AlreadyExistException, ValidationException {
		// TODO Auto-generated method stub
		Dao<Course> dao = new CourseDao();
		boolean flag = false;

		if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
			throw new ValidationException("Course Name Cannot Be Blank");
		} else if (course.getCourseCode() == null || course.getCourseCode().isEmpty()) {
			throw new ValidationException("Course Name Cannot Be Blank");
		} else if (course.getCourseDesc() == null || course.getCourseDesc().isEmpty()) {
			throw new ValidationException("Course Name Cannot Be Blank");
		} else {
			flag = dao.save(course);
		}

		if (flag) {
			// throw exception
			throw new AlreadyExistException("Course Already Exist");
		}

		return flag;

		// return dao.save(course);
	}

	@Override
	public boolean register(StudentCourse studentcourse) throws AlreadyExistException {
		// TODO Auto-generated method stub

		// dao.getInstanceOf("studentcourse").save(studentcourse);

		// Dao<Course> dao = new CourseDao();
		// dao.save(course);
		boolean flag = DaoFactory.getInstance().getDao("studentcourse").save(studentcourse);

		if (flag) {
			throw new AlreadyExistException("Course Already Registered");
		}
		return flag;
	}

	@Override
	public List<StudentCourse> getRegisterCourse(User user) {
		// TODO Auto-generated method stub

		// Dao<StudentCourse> dao = new StudentCourseDao();
		// dao.getAll();

		return DaoFactory.getInstance().getDao("studentcourse").getAll(user);
	}

	@Override
	public List<Course> getAll(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.Optional<Course> get(Course id) {
		// TODO Auto-generated method stub
		return null;
	}

}
