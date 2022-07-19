package com.spring.core.session06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.template.EmpDao;

public class TemplateTest3 {
	
	@Test
	public void test()
	{
		//使用xml配置
		ApplicationContext  ctx =new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao =ctx.getBean("empDao", EmpDao.class);
		empDao.queryEmpAndJob().forEach(System.out::println);
		
		empDao.queryJobAndEmp().forEach(System.out::println);
	}

}
