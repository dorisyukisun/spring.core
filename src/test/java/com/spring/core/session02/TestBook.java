package com.spring.core.session02;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {
	
	@Test
	public void test() 
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Book[] books = {
				ctx.getBean("book1",Book.class),
				ctx.getBean("book2",Book.class),
				ctx.getBean("book3",Book.class),
				ctx.getBean("book4",Book.class),
				ctx.getBean("book5",Book.class),
		};
		Arrays.stream(books).forEach(System.out::println);
	}

}
