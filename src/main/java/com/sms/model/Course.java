package com.sms.model;

public class Course {
	
	
	String courseName;
	String courseCode;
	String courseDesc;
	
	public Course(String courseName, String courseCode, String courseDesc) {
		super();
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.courseDesc = courseDesc;
	}
	public Course() {
		
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	

}
