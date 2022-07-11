package com.spring.core.session03.mvc.repository;

import org.springframework.stereotype.Repository;

import com.spring.core.session03.mvc.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Override
	public void createUser(User user){
		//存入資料庫程序
		//略
		System.out.println("Repository - create user: " + user);
	}
	

}
