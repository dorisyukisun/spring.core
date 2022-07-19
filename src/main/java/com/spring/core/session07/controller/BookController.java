package com.spring.core.session07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.core.session07.exception.InsufficientAmount;
import com.spring.core.session07.exception.InsufficientQuantity;
import com.spring.core.session07.service.BookService;

import com.spring.core.session07.service.ManyBookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ManyBookService manyBookService;
	
	public void buyBook(Integer wid, Integer bid) throws InsufficientAmount, InsufficientQuantity {
		bookService.buyOne(wid, bid);
		System.out.println("buy one ok!");
	}
	
	public void buyBooks(Integer wid, Integer... bids) throws InsufficientAmount, InsufficientQuantity {
		manyBookService.buyMany(wid, bids);
		System.out.println("buy many ok!");
	}
	
	

}
