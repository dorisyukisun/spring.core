package com.spring.core.session07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session07.controller.BookController;

public class TestBook {
      
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookController bookController =ctx.getBean(BookController.class);
		   try {
			   bookController.buyBook(1, 1);// wid, bid
		} catch (Exception e) {
			 System.out.println(e);
		}
					
					
	}
}
