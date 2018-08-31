package com.hpe.dao;

import java.util.List;

import com.hpe.bean.User;
import com.hpe.util.Page;

/**
 * 对user表操作的接口
 * @author YHJ
 *
 */
public interface IUserDao {
	
	//根据用户名及密码查询记录
	User getUser(User user);
	
	//添加一条记录
	boolean saveUser(User user) throws Exception;
	
	//查询所有用户
	List<User> findAllUser();
	
	//分页查询用户
	//User，查询的条件
	Page searchUser(Page page,User user);
	
	//根据id查询用户
	User findUserById(int id);
	
	//根据id修改用户
	boolean updateUserById(User user) throws Exception;
	

}
