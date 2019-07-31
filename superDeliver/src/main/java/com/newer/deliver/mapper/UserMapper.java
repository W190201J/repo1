package com.newer.deliver.mapper;

import org.springframework.stereotype.Repository;

import com.newer.deliver.pojo.User;

/**
 * 用户相关的数据操作
 * @author bilibili丶饭炒蛋
 *
 */
@Repository
public interface UserMapper {
	
	//注册
	public int insert(User user);
	
	
	//验证(登录)
	public User login(String phone);
	


}
