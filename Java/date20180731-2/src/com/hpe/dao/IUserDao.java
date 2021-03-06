package com.hpe.dao;

import java.util.List;

import com.hpe.po.User;

public interface IUserDao {

	//添加
	int addUser(User user);
		
	//根据用户名删除
	int deleteUserByName(String name);

	//根据用户名修改
	int updateByName(User user);
	//根据用户名查询
	User selectByName(String name);
	
	//查询全部
	List<User> selectAll();
}
