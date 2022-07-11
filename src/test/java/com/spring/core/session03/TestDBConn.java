package com.spring.core.session03;

 
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.mvc.method.annotation.CallableMethodReturnValueHandler;

public class TestDBConn {
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DBConn dbConn =ctx.getBean("dbconn",DBConn.class);
		System.out.println(dbConn);
		dbConn.query();
		dbConn.query();
		dbConn.query();
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
