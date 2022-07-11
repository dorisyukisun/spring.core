package com.spring.core.session04.sta;

//靜態代理
//代理執行業務
public class PersonProxy implements Person{
	
	//代理對象
		private Person person;
		
		public PersonProxy (Person person)
		{
			this.person = person;
		}
	@Override
	public void work() {
		 // before:公用邏輯
		System.out.println("戴口罩");
		//代理執行業務方法
		try {
		person.work();
		}catch(Exception e ){
			//exception 例外的公用方法
			System.out.println("去買口罩");
			
		}
		// end 公用邏輯
		System.out.println("脱口罩");
		
	}
	
	

}
