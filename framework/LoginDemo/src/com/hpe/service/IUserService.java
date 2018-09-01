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

	/**
	 *  登录
	 *  
	 * @param user
	 * 			username 用户名
	 * 			pwd 密码
	 * @return
	 * 		user对象 登录成功
	 * 		null 登录失败
	 */
	User login(User user);
	
	/**
	 *  注册
	 *  
	 * @param 
	 * 		user 注册信息
	 * @return
	 * 		true 注册成功
	 * 		false 注册失败
	 */
	boolean saveUser(User user);

	/**
	 *  注册
	 *  
	 * @param 
	 * 		page 查询信息
	 * @return
	 * 		page对象 查询成功
	 * 		null  查询失败
	 */
	Page searchUser(Page page);
	
	/**
	 *  根据id查询用户
	 *  
	 * @param 
	 * 		id 用户id
	 * @return
	 * 		user对象 查询成功
	 * 		null  查询失败
	 */
	User findUserById(int id);
	
	/**
	 *  根据id修改用户
	 *  
	 * @param 
	 * 		user 修改信息
	 * @return
	* 		true 修改成功
	 * 		false 修改失败
	 */
	boolean updateUserById(User user);
	
	/**
	 *  根据id删除用户
	 *  
	 * @param 
	 * 		id 用户id
	 * @return
	* 		true 删除成功
	 * 		false 删除失败
	 */
	boolean deleteUserById(int id);
	
}
