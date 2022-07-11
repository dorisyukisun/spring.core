package com.spring.core.session01.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.core.session01.beans.Hello;


//java 配置
@Configuration
//@ComponentScan("com.spring.core.session01.beans.conf")
public class SpringConfig {
	
	@Bean(name= "hello")
	public Hello getHello() {
		Hello hello = new Hello();
		return hello ;
		
	}
	
	

}
