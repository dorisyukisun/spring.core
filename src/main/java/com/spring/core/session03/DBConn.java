package com.spring.core.session03;

public class DBConn {
	
	public void init() {
		System.out.println("資料庫開啟連線");
		
	}
	public void query() {
		System.out.println("查詢資料...");
	}
	
	public void destory() {
		System.out.println("關閉off資料庫連線");
	}

}
