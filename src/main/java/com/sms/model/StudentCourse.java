package com.sms.model;

public class StudentCourse {
	
	String username;
	String courseCode;
	String course_name;
	String course_desc;
	public String getCourse_desc() {
		return course_desc;
	}
	public void setCourse_desc(String course_desc) {
		this.course_desc = course_desc;
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
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public StudentCourse() {
		
	}
	public StudentCourse(String username, String courseCode) {
		
		this.username = username;
		this.courseCode = courseCode;
	}
	public StudentCourse(String course_name, String courseCode, String course_desc) {
		
		this.courseCode = courseCode;
		this.course_name = course_name;
		this.course_desc = course_desc;
	}
	
	

}
