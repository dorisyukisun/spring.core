package com.spring.core.session07.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.core.session07.Dao.BookDao;
import com.spring.core.session07.exception.InsufficientAmount;
import com.spring.core.session07.exception.InsufficientQuantity;

@Service
public class BookServicelmpl implements BookService{
	
	
	@Autowired
	private BookDao bookDao;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 3
			,rollbackFor = {InsufficientQuantity.class, InsufficientAmount.class}) //或是 Exception.class 
	/*
	 * Propagation.REQUIRED (預設）:如果有事物在運行,當前方法就在該事務中運行
	 * 否則就啟動一個新的事物,並在自己的事務中運行
	 * Propagation.REQUIRES_NEW:當前方法必須啟動新的事物,並在自己的事務內運行,如果之前事務正在運行,就會將它掛起不用
	 * Propagation.SUPPORTS: 如果有事物在運行,當前方法就在此事務中運行,否則就不再事務中運行
	 * Propagation.NOTSUPPORTS:當前方法不應該在事務中運行,如果有事務就會會將他掛起不用
	 * Propagation.MANDATORY:當前方法必須在運行在事務中,若沒有就拋出異常
	 * Propagation.NEVER:當前方法不應該運行在事務中,若在事務中就拋出異常
	 * Propagation.NESTED:如果有事務在運行,當前方法必須嵌套在事務中,否則一啟動一個新事物並在自己的事務中運行
	 * 事務的隔離級別
	 * Isolation 事務的隔離級別,在病發的情況之下,操作數據CRUD的一種規則
	 * Isolation.DEFAULT: 預設 MySQL預設是 Isolation.REPEATABLE_READ 可重複讀
	 * Isolation.READ_UNCOMMITTED 讀未提交: 贓讀(針對欄位資料)
	 * Isolation.READ_COMMITTED 讀已提交: 不可重複讀(針對欄位資料)
	 * Isolation.REPEATABLE_READ 可重複讀: 幻讀 其他人不可以針對指定資料列RUD(針對欄位資料列)
	 * Isolation.SERIALIZABLE 序列畫:效能低,消耗大,但是可以簡單解決上面的問題(實務上不建議使用)針對資料表
	 * 
	 * 拋出 RuntimeException 會自動rollback
	 * 拋出 Exception 則必須自訂 rollbackFor= Exception.class
	 */
	@Override
	public void buyOne(Integer wid, Integer bid) throws InsufficientAmount, InsufficientQuantity
	{
		//減去一本庫存
		bookDao.updateStock(bid, 1);
		/*
			 Thread.sleep(4000);
		}catch (Exception e) {
			// TODO: handle exception
		}*/
		//取得書籍價格
		Integer price = bookDao.getPrice(bid);
		//減去錢包裡的錢
		bookDao.updateWallet(wid, price);
		
	
		
	}

}
