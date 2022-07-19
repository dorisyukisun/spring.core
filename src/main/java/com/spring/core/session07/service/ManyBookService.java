package com.spring.core.session07.service;

import com.spring.core.session07.exception.InsufficientAmount;
import com.spring.core.session07.exception.InsufficientQuantity;

public interface ManyBookService {
	
	
	void buyMany(Integer wid, Integer... bids)throws InsufficientAmount, InsufficientQuantity;

}
