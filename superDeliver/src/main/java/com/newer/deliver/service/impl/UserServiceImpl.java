package com.newer.deliver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.deliver.mapper.UserMapper;
import com.newer.deliver.pojo.User;
import com.newer.deliver.service.UserService;

@Service("user")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper umper;

	//注册
	@Override
	public int register(User user) {
		return umper.insert(user);
	}

	//登录
	@Override
	public User login(String phone) {
		return umper.login(phone);
	}

}
