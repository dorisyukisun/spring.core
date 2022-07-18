package com.spring.core.session07.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.core.session07.exception.InsufficientAmount;
import com.spring.core.session07.exception.InsufficientQuantity;
 
@Repository
public class BookDaolmpl implements BookDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer getPrice(Integer bid) {
		String sql = "select price from book where bid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, bid);
	}

	@Override
	public Integer getStockAmount(Integer bid) {
		String sql = "select amount from stock where bid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, bid);
	}

	@Override
	public Integer getWalletMoney(Integer wid) {
		String sql = "select money from wallet where wid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, wid);
	}
	
	// 減去庫存
	@Override
	public Integer updateStock(Integer bid, Integer amount) throws InsufficientQuantity {
		// 確認該書的最新庫存量
		Integer new_amount = getStockAmount(bid);
		if(new_amount <= 0) {
			throw new InsufficientQuantity(String.format("此書號:%d 庫存不足, 目前數量:%d", bid, new_amount));
		} else if(new_amount < amount) {
			throw new InsufficientQuantity(String.format("此書號:%d 庫存不足, 目前數量:%d 欲購買數量:%d", bid, new_amount, amount));
		}
		// 修改庫存
		String sql = "update stock set amount=amount-? where bid=?";
		return jdbcTemplate.update(sql, amount, bid);
	}
	
	// 減去餘額
	@Override
	public Integer updateWallet(Integer wid, Integer money) throws InsufficientAmount {
		// 先確認錢包裡的餘額
		Integer new_money = getWalletMoney(wid);
		if(new_money <= 0) {
			throw new InsufficientAmount(String.format("錢包號碼:%d 餘額不足, 目前餘額:%d", wid, new_money));
		} else if(new_money < money) {
			throw new InsufficientAmount(String.format("錢包號碼:%d 餘額不足, 目前餘額:%d 預扣款金額:%d" , wid, new_money, money));
		}
		// 修改餘額
		String sql = "update wallet set money=money-? where wid=?";
		return jdbcTemplate.update(sql, money, wid);
	}

	 
	
}