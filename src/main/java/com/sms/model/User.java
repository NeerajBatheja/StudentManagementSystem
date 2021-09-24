package com.sms.model;

import com.sms.model.enums.UserType;

public class User {
	
	String name;
	String userName;
	String password;
//	String accountType;
	UserType type;
	
	public User(String userName , String password)
	{
		this.userName = userName;
		this.password = password;
	}
	public User()
	{
		
	}
	
	public User(String name, String userName, String password, UserType accountType) {
		
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.type = accountType;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}



}
