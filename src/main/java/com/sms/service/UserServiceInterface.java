package com.sms.service;

import com.sms.exception.AuthenticationException;
import com.sms.exception.ValidationException;

public interface UserServiceInterface<T> {

	T authenticate(T t) throws AuthenticationException, ValidationException;
}
