package com.hp.service;

import java.util.List;

import com.hp.po.Asset;
import com.hp.po.User;

/**
 * @Description:对user表操作的接口
 * @author chaoling
 * @date 2018年8月1日
 */
public interface IUserService {
	
	/**
	 * @Description: 普通用户登录
	 * @param user 用户名/密码
	 * @return -1 用户名不存在 0 密码错误 >0 用户Id 
	 */
	int loginUser(User user);
	
	/**
	 * @Description: 用户注册
	 * @param user 用户信息
	 * @return -1 该用户民已存在  >0 注册成功  0 注册失败  
	 */
	int registerUser(User user);
	
	/**
	 * @Description: 查询所有的普通用户
	 * @return list 所有的用户记录
	 */
	List<User> selectAllUser();

	/**
	 * @Description: 修改密码
	 * @param user 需要修改的信息
	 * @return true 修改成功 false修改失败  
	 */
	boolean updataUserPassword(User user);
	
}
