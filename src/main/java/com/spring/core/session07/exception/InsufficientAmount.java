package com.spring.core.session07.exception;

//餘額不足例外
public class InsufficientAmount extends Exception{
	
	public InsufficientAmount(String message) {
	 super(message);
	}
}
