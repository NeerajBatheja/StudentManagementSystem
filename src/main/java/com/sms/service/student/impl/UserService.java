package com.sms.service.student.impl;

import java.util.List;
import java.util.Optional;

import com.sms.dao.Dao;
import com.sms.dao.UserDao;
import com.sms.dao.factory.DaoFactory;
import com.sms.exception.AlreadyExistException;
import com.sms.exception.AuthenticationException;
import com.sms.exception.GeneralException;
import com.sms.exception.ValidationException;
import com.sms.model.Course;
import com.sms.model.User;
import com.sms.service.Iservice;
import com.sms.service.UserServiceInterface;

public class UserService implements Iservice<User>, UserServiceInterface<User> {

	@Override
	public Optional<User> get(User id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		Dao<User> dao = new UserDao();

		return dao.getAll();
	}

	@Override
	public void update(User t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean add(User user) throws AlreadyExistException, ValidationException {
		Dao<User> dao = new UserDao();

		// user
		// validation()
		boolean flag = false;

		if ((user.getUserName() == null || user.getUserName().isEmpty())
				|| (user.getPassword() == null || user.getPassword().isEmpty())
				|| (user.getName() == null || user.getName().isEmpty())) {
			throw new ValidationException("Name , Username Or Password Cannot be Blank");

		} else {
			flag = dao.save(user);
			if (flag) {
				// throw exception
				throw new AlreadyExistException("User Already Exist");
			}
		}

		return flag;

		// TODO Auto-generated method stub

	}

	@Override
	public User authenticate(User user) throws ValidationException, AuthenticationException {

		// Dao<User> dao = new UserDao();
		// Optional<User> userData = dao.get(user);
		// DaoFactory<User> dao = new DaoFactory();
		// Optional<User> userData = dao.getInstanceOf("userdao").get(user);
		if ((user.getUserName() == null || user.getUserName().isEmpty())
				|| (user.getPassword() == null || user.getPassword().isEmpty())) {
			throw new ValidationException("Username Or Password Cannot be Blank");

		} else {
			Optional<User> userData = DaoFactory.getInstance().getDao("userdao").get(user);
			if (userData != null && userData.isPresent()) {
				return userData.get();
			} else {
				throw new AuthenticationException("Invalid Credentials");
			}
		}

		// UserDao userDao = new UserDao();
		// Optional<User> userData = userDao.get(user);

	}

	@Override
	public List<User> getAll(User t) {
		// TODO Auto-generated method stub
		return null;
	}

}
