package com.spring.core.session04.dyn;

import java.util.Arrays;

import org.springframework.core.style.ToStringCreator;

// Aspect切面程式 (公用邏輯)
public class MyLogger {
	// Before:前置通知(業務方法調用前要執行的程式）
	public static void before(Class cls,String methodName,Object[] args) {
		System.out.printf("MyLogger 前置通知: %S %S args=%s\n",cls,methodName,Arrays.toString(args));
	}
	
	//Exception: 例外異常通知（執行業務方法時發生例外所要執行的程式)
	public static void throwing(Class cls, Throwable throwble) {
				System.out.printf("MyLogger 例外異常通知:%S %S/n",cls,throwble);
	}
	//End:後置通知(業務方法調用完畢後要執行的程式
	public static void end(Class cls, String methodName, Object result) {
		System.out.printf("MyLogger 後製通知: %S %S result=%S\n", cls,methodName,result);
	}
	

}
