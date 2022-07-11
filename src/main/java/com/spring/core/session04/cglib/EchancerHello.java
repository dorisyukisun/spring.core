package com.spring.core.session04.cglib;

//Echancer 增強
//子類別具有增強父類別的特性
public class EchancerHello extends Hello {

	@Override //覆寫 /攔截 (Interceptor)
	public String sayHello(String str) {
		String message ="請出示實連 QRcode";
		return super.sayHello(str) +message;
	}
	
	

}
