package com.spring.core.session06
;

import java.util.Arrays;

import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.template.EmpDao;

public class TemplateTest4 {
	
	@Test
	public void test() {
		//使用xml 配置
		ApplicationContext ctx =new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao =ctx.getBean("empDao", EmpDao.class);
		
		int[] rowcount =empDao.addTwoTx("Z06", 20,"Z05", 21);
		System.out.println(Arrays.toString(rowcount));
	}

}
