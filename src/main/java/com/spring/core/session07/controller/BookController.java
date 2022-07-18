package com.spring.core.session07.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.core.session07.service.BookService;

public class BookController {
	
	@Autowired
	private BookService bookService;
	
	public void buyBook(Integer wid, Integer bid) {
		
		
	}
	
	public void buyBooks (Integer wid, Integer... bid)
	{
		
	}
	
	

}
