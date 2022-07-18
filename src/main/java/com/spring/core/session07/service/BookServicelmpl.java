package com.spring.core.session07.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.core.session07.Dao.BookDao;
import com.spring.core.session07.exception.InsufficientAmount;
import com.spring.core.session07.exception.InsufficientQuantity;

public class BookServicelmpl implements BookService{
	
	
	@Autowired
	private BookDao bookDao;
	
	public void buyOne(Integer wid, Integer bid) throws InsufficientAmount, InsufficientQuantity
	{
		//減去一本庫存
		bookDao.updateStock(bid, 1);
		//取得書籍價格
		Integer price = bookDao.getPrice(bid);
		//減去錢包裡的錢
		bookDao.updateWallet(wid, price);
		
	}

	@Override
	public void buyMoney(Integer wid, Integer... bids) throws InsufficientAmount, InsufficientQuantity {
		 for(Integer bid:bids)
		 {
			 buyOne(wid, bid);
		 }
		
	}

}
