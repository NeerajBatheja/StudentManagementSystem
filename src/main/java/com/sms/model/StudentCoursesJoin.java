package com.sms.model;

public class StudentCoursesJoin {
	String username;
	String courseCode;
	String status;
	
	public StudentCoursesJoin()
	{
		
	}
	
	public StudentCoursesJoin(String username, String courseCode, String status) {
		super();
		this.username = username;
		this.courseCode = courseCode;
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
