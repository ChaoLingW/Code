package com.hpe.service;

import java.util.List;

import com.hpe.po.User;

public interface IUserService {

	/**
	 * @Description: 查看所有用户的业务
	 * @return 所有的user记录
	 */
	List<User> selectAllUser();
	
	/**
	 * @Description: 注册业务
	 * @param user
	 * @return >0 插入的主键 0 插入失败 -1 用户名已存在
	 */
	int regist(User user);
	
	/**
	 * @Description: 登录业务
	 * @param user
	 * @return 对应的记录 ，null不存在
	 */
	User login(User user);
    
	/**
	 * @Description:修改密码
	 * @param user
	 * @return true 修改成功 false 修改失败
	 */
	boolean changPwd(User user);

}
