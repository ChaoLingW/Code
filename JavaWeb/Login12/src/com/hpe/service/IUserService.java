package com.hpe.service;

import java.util.List;

import com.hpe.bean.User;
import com.hpe.util.Page;

/**
 * 用户管理的业务接口
 * @author YHJ
 *
 */
public interface IUserService {

	//登陆
	User login(User user);
	
	//注册
	boolean saveUser(User user);
	
	//查询所有用户
	List<User> findAllUser();
	
	//查询用户
	Page searchUser(Page page,User user);
	
	//根据id查询用户
	User findUserById(int id);
	
	//根据id修改用户
	boolean updateUserById(User user);
	
}
