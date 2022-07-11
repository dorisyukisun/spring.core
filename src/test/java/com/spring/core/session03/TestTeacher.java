package com.spring.core.session03;

import java.util.IntSummaryStatistics;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.Teacher;

public class TestTeacher {
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Teacher teacher1 =ctx.getBean("teacher1",Teacher.class);
		System.out.println(teacher1);
		//請問teacher 1 的學生每個人平均幾學分？
		teacher1.getStudents().stream()
			.map(s -> s.getClazzs())
			.forEach(s ->{
				int sum = s.stream().mapToInt(c -> c.getCredit()).sum();
				double avg = s.stream().mapToInt(c -> c.getCredit()).average().getAsDouble();
			System.out.println(sum+","+avg);
			
			//統計
			IntSummaryStatistics stat = s.stream().mapToInt(c->c.getCredit()).summaryStatistics();
			System.out.println(stat);
			});
	}
	

}
