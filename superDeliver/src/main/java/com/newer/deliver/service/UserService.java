package com.newer.deliver.service;

import com.newer.deliver.pojo.User;

/**
 * User数据操作接口
 * @author bilibili丶饭炒蛋
 *
 */
public interface UserService {
	
	//注册
	public int register (User user);
	
	//登录
	public User login(String phone);
	

	//修改密码
	public int changPass(User user);

	//检测用户是否存在
	public User checkPhone(User user);
}
