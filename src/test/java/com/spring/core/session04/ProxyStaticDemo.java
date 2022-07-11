package com.spring.core.session04;

import org.junit.Test;

import com.spring.core.session04.sta.Man;
import com.spring.core.session04.sta.Person;
import com.spring.core.session04.sta.PersonProxy;
import com.spring.core.session04.sta.Woman;


public class ProxyStaticDemo {
	
	@Test
	public void test() {
		//不透過代理直接執行
		/*Person man = new Man();
		Person woman = new Woman();
		man.work();
		woman.work();
		*/
		//透過代理模式來執行
		Person man = new PersonProxy(new Man());
		Person woman = new PersonProxy(new Woman());
		man.work();
		woman.work();
				
	
	}

}
