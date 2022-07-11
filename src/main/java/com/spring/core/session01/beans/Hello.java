package com.spring.core.session01.beans;

import java.util.Date;

public class Hello {
	
	Date todayDate = new Date();

	@Override
	public String toString() {
		return "Hello Bean" + todayDate;
	}
	
	
	

}
