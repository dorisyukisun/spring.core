package com.spring.core.session03.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.core.session03.mvc.model.User;
import com.spring.core.session03.mvc.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void addUser(User user) {
		//驗證 user 物件
		//略...
		//驗證通過
		System.out.println("Service - add user:"+user);
		userDao.createUser(user);
	}
	
	


}
