package com.hpe.dao;

import java.util.List;

import com.hpe.po.User;

public interface IUserDao {

	/**
	 * 根据用户名密码查询
	 * 		通常用户用户登录验证
	 * 
	 * @param user User兑现  必须包含username与password属性
	 * 			username 用户名
	 * 			password 密码
	 * @return
	 * 			User对象 查询成功
	 * 			null  查询失败 
	 */
	User selectUserByNameAndPwd(User user);
	
	/**
	 *  根据查询条件查询
	 * @param user 
	 * 			用户对象 查询条件
	 * @return 
	 * 			User列表 查询成功
	 * 			null  查询失败
	 */
	List<User> select (User user);
	
	/**
	 *  根据id修改信息
	 * @param user 
	 * 			用户对象 修改信息
	 * @return 	受影响的行数
	 * 			 >0修改成功
	 * 			<=0  修改失败
	 */
	int updateById (User user);
	
	/**
	 *  根据id删除信息
	 * @param id 
	 * 			待删除用户id组成的列表
	 * @return 	受影响的行数
	 * 			 >0删除成功
	 * 			<=0  删除失败
	 */
	int deleteById (List<Integer> id);


}
