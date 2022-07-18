package com.spring.core.session07.service;

import com.spring.core.session07.exception.InsufficientAmount;
import com.spring.core.session07.exception.InsufficientQuantity;

public interface BookService {
	
	void buyOne (Integer wid, Integer bid) throws InsufficientAmount,InsufficientQuantity;
	void buyMoney(Integer wid, Integer ...bids)throws InsufficientAmount, InsufficientQuantity;
	

}
