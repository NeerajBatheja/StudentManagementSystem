package com.sms.model.enums;

public enum UserType {

	STUDENT ("Student"), 
	TEACHER ("Teacher"),
	ADMIN ("Admin");
	
	 private UserType(String label) {
		this.label = label;
	}

	public final String label;
	
	public static UserType valueOfLabel(String value)
	{
		for(UserType type: values()) {
			
			if(type.label.equalsIgnoreCase(value)){
				
				return type;
				
			}
			
			
		}
		return null;
	}

}
