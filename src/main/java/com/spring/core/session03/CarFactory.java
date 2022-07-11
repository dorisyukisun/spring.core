package com.spring.core.session03;

import java.util.Random;

import org.springframework.beans.factory.FactoryBean;

public class CarFactory implements FactoryBean<Car>{

	@Override
	public Car getObject() throws Exception {
		Random random = new Random();
		return new Car("保時捷",random.nextInt(600_0000));
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		 
		return true;
	}
	
	

}
