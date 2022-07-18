package com.spring.core.session07.Dao;

import com.spring.core.session07.exception.InsufficientAmount;
import com.spring.core.session07.exception.InsufficientQuantity;

public interface BookDao {
	Integer getPrice(Integer bid);// 根據 bid 取得書本價格
	Integer getStockAmount(Integer bid);// 根據 bid 取得庫存數量
	Integer getWalletMoney(Integer bid); // 根據 wid 取得可用餘額
	Integer updateStock(Integer bid, Integer amount) throws InsufficientQuantity;// 減去庫存
	Integer updateWallet(Integer wid, Integer money) throws InsufficientAmount;// 減去餘額
	 
	 
	

}
