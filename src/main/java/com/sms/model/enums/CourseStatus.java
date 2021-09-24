package com.sms.model.enums;

public enum CourseStatus {

	FEE_PENDING("FEE PENDING"), FEE_PAID("FEE PAID"), REGISTERED("REGISTERED");

	String label;

	private CourseStatus(String label) {
		this.label = label;
	}

	public static CourseStatus valueOfStatus(String value) {
		for (CourseStatus status : values()) {

			if (status.label.equalsIgnoreCase(value)) {

				return status;

			}

		}
		return null;

	}
}
