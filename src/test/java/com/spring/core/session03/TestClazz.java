package com.spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.Clazz;

public class TestClazz {
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Clazz clazz = ctx.getBean("clazz1", Clazz.class);
		System.out.println(clazz);
	}

}
