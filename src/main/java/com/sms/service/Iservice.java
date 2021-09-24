package com.sms.service;

import java.util.List;
import java.util.Optional;

import com.sms.exception.AlreadyExistException;
import com.sms.exception.GeneralException;
import com.sms.exception.ValidationException;
import com.sms.model.User;

public interface Iservice<T> {
	
		Optional<T> get(T id);
	    
	    List<T> getAll();
	    List<T> getAll(User user);
	    
	    void update(T t, String[] params);
	    
	    void delete(T t);
	    
	     boolean add(T t) throws AlreadyExistException, ValidationException;
	    
	    
	    
	    
	

}
