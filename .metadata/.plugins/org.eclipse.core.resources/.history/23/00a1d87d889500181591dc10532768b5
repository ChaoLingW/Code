package com.hp.dao;

import java.util.List;

import com.hp.po.User;

/**
 * @Description:对user表操作的接口
 * @author chaoling
 * @date 2018年7月30日
 */
public interface IUserDao {
	
	/**
	 * @Description: 登录验证
	 * @return  user
	 * @throws SQLException
	 */
	public User loginUser();
	
	/**
	 * @Description 根据用户名对本用户名下的密码进行修改
	 * @param user
	 * @return > 0 修改成功 
	 * @throws SQLException
	 */
	public int updateByNameToPassword(User user);

	/**
	 * @Description: 查询所有用户
	 * @return users 当为null且size()为0时说明user表为空   
	 * @throws SQLException
	 */
	public List<User> seleteAllUser();
	
	/**
	 * @Description: 根据userName查询是否存在该userName的记录
	 * @param name
	 * @return user 为null不存在
	 * @throws SQLException
	 */
	public User seleteUserByUserName(String name);
	
	/**
	 * @Description: 添加一条记录
	 * @param user
	 * @return > 0  添加成功; 
	 * @throws SQLException
	 */
	public int addUser(User user);
	
}
