package com.spring.core.session07.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.core.session07.exception.InsufficientAmount;
import com.spring.core.session07.exception.InsufficientQuantity;

public class ManyBookServicelmpl {
	
	@Autowired
	private BookService bookService;
	
	
	public void buyMany(Integer wid, Integer...bids)throws InsufficientAmount, InsufficientQuantity{
		 
		for(Integer bid :bids) {
			bookService.buyOne(wid, bid);
		}
	}

}
