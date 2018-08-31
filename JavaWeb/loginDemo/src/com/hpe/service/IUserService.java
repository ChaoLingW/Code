package com.hpe.service;

import java.util.List;

import com.hpe.bean.User;
import com.hpe.util.Page;

/**
 * 用户管理的业务接口
 * @author chaoling
 */
public interface IUserService {
	
	/**
	 * 登陆
	 * @param user 必须存放username与pwd
	 * @return User
	 */
	User login(User user);

	/**
	 * 注册
	 * @param user 待添加的user记录
	 * @return true 注册成功，false 注册失败
	 */
	boolean register(User user);
	
	/**
	 * 显示user表中所有的用户记录
	 * @return user表中所有的用户记录
	 */
	List<User> findAllUser();
	
	/**
	 * TODO 模糊查询
	 * @param page
	 * @param user
	 * @return
	 */
	Page searchUser(Page page,User user);
	
	/**
	 * TODO 根据id 查询用户
	 * @param id
	 * @return
	 */
	User findUserById(int id);

	/**
	 * TODO 删除指定id的用户
	 * @param id 待删除用户的id
	 * @return true 删除成功，false 删除失败
	 */
	boolean deleteUser(int id);
	
	/**
	 * TODO 根据id修改用户
	 * @param user 待修改的用户的信息
	 * @return true 删除成功，false 删除失败
	 */
	boolean updateUser(User user);
	
}
