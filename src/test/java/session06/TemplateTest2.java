package session06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.SpringJDBCConfig;
import com.spring.core.session06.entity.Emp;
import com.spring.core.session06.template.EmpDao;

public class TemplateTest2 {
	@Test
	public void test()
	{
		//使用xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao =ctx.getBean("empDao", EmpDao.class);
		//測試單筆新增 I
		//int rowcont = empDao.addOne1("test1", 18);
		//System.out.println(rowcont);
		//測試單筆新增 II
	    //int rowcont = empDao.addOne2("test2", 9);
		//System.out.println(rowcont);
		//測試批次新增I
		/*List<Object[]> rows =new ArrayList<>();
		rows.add(new Object[] {"jo", 20});
		rows.add(new Object[] {"Mary",19});
		rows.add(new Object[] {"Helen", 22});
		int[] rowcounts = empDao.batchAdd1(rows);
		System.out.println(Arrays.toString(rowcounts));
		*/
		//測試批次新增II
		/*
		List<Emp> emps = new ArrayList<>();
		emps.add(new Emp("Rose", 23));
		emps.add(new Emp("Jack", 24));
		int[] rowcounts = empDao.batchAdd2(emps);
		System.out.println(Arrays.toString(rowcounts));
		*/
		//修改
		/*int rowcount =empDao.updateById(1, "AA1", 21);
		System.out.println(rowcount);
		*/
		//刪除
		int rowcount = empDao.deletById(14);
		System.out.println(rowcount);
		
		//單筆查詢
		//System.out.println(empDao.getEmpById(1));
		
		
		
		
		
	}

}
