package com.spring.core.session06
;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.SpringJDBCConfig;
import com.spring.core.session06.entity.Emp;
import com.spring.core.session06.template.EmpDao;

public class TemplateTest1 {
	
	public void test()
	{
		//使用xml 配置
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		//使用java 配置
		ApplicationContext ctx =new AnnotationConfigApplicationContext(SpringJDBCConfig.class);
		
		EmpDao empDao =ctx.getBean("empDao", EmpDao.class);
		List<Map<String,Object>> emps= empDao.queryAll();
		System.out.println(emps);
		//如何取得 eid =2 的員工姓名 ? (請使用 java 8 Stream)
		String ename =emps.stream()
				.filter(e -> e.get("eid").toString().equals("2"))
				.findFirst()
				.get()
				.get("ename").toString();
		System.out.println(ename);
		
		List<Emp> emps2= empDao.queryAllEmps();
		System.out.println(emps2);
		
		emps2 = empDao.queryAllEmps2();
		System.out.println(emps2);
	}
		
	
	}


