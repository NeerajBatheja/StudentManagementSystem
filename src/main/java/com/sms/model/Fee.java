package com.sms.model;

public class Fee {

	String feeAmount;
	String courseCode;

	public String getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(String feeAmount) {
		this.feeAmount = feeAmount;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public Fee(String feeAmount, String courseCode) {

		this.feeAmount = feeAmount;
		this.courseCode = courseCode;
	}

}
